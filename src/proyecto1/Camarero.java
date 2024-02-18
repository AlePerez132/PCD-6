/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author alepd
 */
public class Camarero extends Thread {

    private Semaphore dosisLeche, dosisCafe;
    private CanvasCafeteria cc;
    boolean seguir;

    public Camarero(Semaphore dosisLeche, Semaphore dosisCafe, CanvasCafeteria cc) {
        this.dosisLeche = dosisLeche;
        this.dosisCafe = dosisCafe;
        this.cc = cc;
        seguir = true;
    }

    public void setSeguir(boolean seguir) {
        this.seguir = seguir;
    }

    @Override
    public void run() {
        while (seguir) {
            try {
                sleep(6000); // Intervalo de recarga
                
                cc.camarero('C');
                sleep(2000);
                dosisCafe.release(5);
                cc.fincamarero();

                cc.camarero('L');
                sleep(2000);
                dosisLeche.release(5);
                cc.fincamarero();

                System.out.println("Recarga - Café: " + dosisCafe.availablePermits() + ", Leche: " + dosisLeche.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
