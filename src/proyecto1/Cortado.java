/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import proyecto1.CanvasCafeteria.cliente;

/**
 *
 * @author alepd
 */
public class Cortado extends Thread{

    private Semaphore salaCafe, salaLeche, dosisCafe, dosisLeche, papelera;
    private CanvasCafeteria cc;
    final int tiempoDormir = 1000;

    public Cortado(Semaphore salaCafe, Semaphore salaLeche, Semaphore dosisCafe, Semaphore dosisLeche, Semaphore papelera, CanvasCafeteria cc) {
        this.salaCafe = salaCafe;
        this.salaLeche = salaLeche;
        this.dosisCafe = dosisCafe;
        this.dosisLeche = dosisLeche;
        this.papelera = papelera;
        this.cc = cc;
    }

    public void run() {
        try {
            int id = (int) Thread.currentThread().getId();
            System.out.println("Empieza cortado " + id);
            
            cc.encolaleche(id, 'C' , 0, 0);
            sleep(tiempoDormir);
            salaLeche.acquire();
            cc.fincolaleche(id, 'C', 0, 0);
            cc.ensalaleche(id, 'C', 0, 0);
            sleep(tiempoDormir);
            dosisLeche.acquire(1);
            cc.ensalaleche(id, 'C', 1, 0);
            sleep(tiempoDormir);
            salaLeche.release();
            cc.finsalaleche(id, 'C', 1, 0);
            System.out.println("El cortado " + id + " ha cogido la leche");

            cc.encolacafe(id, 'C', 1, 0);
            sleep(tiempoDormir);
            salaCafe.acquire();
            cc.fincolacafe(id, 'C', 1, 0);
            cc.ensalacafe(id, 'C', 1, 0);
            sleep(tiempoDormir);
            dosisCafe.acquire(2);
            cc.ensalacafe(id, 'C', 1, 2);
            sleep(tiempoDormir);
            salaCafe.release();
            cc.finsalacafe(id, 'C', 1, 2);
            System.out.println("El cortado " + id + " ha cogido el cafe");

            cc.ensalon(id, 'C', 1, 2);
            System.out.println("Cortado " + id + " toma café - Café: " + dosisCafe.availablePermits() + ", Leche: " + dosisLeche.availablePermits());
            
            sleep((long) (Math.random() * 3000) + 1000); // Tiempo de tomar café
            cc.finsalon(id, 'C', 1, 2);
            
            cc.encolapapelera(id, 'C', 1, 2);
            papelera.acquire();
            cc.fincolapapelera(id, 'C', 1, 2);
            cc.enpapelera(id, 'C', 1, 2);
            sleep(1000);
            cc.finpapelera(id, 'C', 1, 2);
            System.out.println("Cortado " + id + " tira la taza");
            papelera.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
