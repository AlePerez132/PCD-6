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
public class Manchado implements Runnable{
     private Semaphore salaCafe, salaLeche, dosisCafe, dosisLeche, papelera;
     private CanvasCafeteria cc;
     final int tiempoDormir = 1000;

    public Manchado(Semaphore salaCafe, Semaphore salaLeche, Semaphore dosisCafe, Semaphore dosisLeche, Semaphore papelera, CanvasCafeteria cc) {
        this.salaCafe = salaCafe;
        this.salaLeche = salaLeche;
        this.dosisCafe = dosisCafe;
        this.dosisLeche = dosisLeche;
        this.papelera = papelera;
        this.cc = cc;
    }

     @Override
    public void run() {
        try {
            int id = (int) Thread.currentThread().getId();
            System.out.println("Empieza manchado " + id);
            
            cc.encolacafe(id, 'M', 0, 0);
            sleep(tiempoDormir);
            salaCafe.acquire();
            cc.fincolacafe(id, 'M', 0, 0);
            cc.ensalacafe(id, 'M', 0, 0);
            sleep(tiempoDormir);
            dosisCafe.acquire(1);
            cc.ensalacafe(id, 'M', 0, 1);
            sleep(tiempoDormir);
            salaCafe.release();
            cc.finsalacafe(id, 'M', 0, 1);
            System.out.println("El manchado " + id + " ha cogido el cafe");

            cc.encolaleche(id, 'M', 0, 1);
            salaLeche.acquire();
            cc.fincolaleche(id, 'M', 0, 1);
            cc.ensalaleche(id, 'M', 0, 1);
            sleep(tiempoDormir);
            dosisLeche.acquire(2);
            cc.ensalaleche(id, 'M', 2, 1);
            sleep(tiempoDormir);
            salaLeche.release();
            cc.finsalaleche(id, 'M', 2, 1);
            System.out.println("El manchado " + id + " ha cogido la leche");

            cc.ensalon(id, 'M', 2, 1);
            System.out.println("Manchado " + id + " toma café - Café: " + dosisCafe.availablePermits() + ", Leche: " + dosisLeche.availablePermits());
            
            sleep((long) (Math.random() * 3000) + 1000); // Tiempo de tomar café
            cc.finsalon(id, 'M', 2, 1);

            cc.encolapapelera(id, 'M', 2, 1);
            papelera.acquire();
            cc.fincolapapelera(id, 'M', 2, 1);
            cc.enpapelera(id, 'M', 2,1);
            sleep(1000);
            cc.finpapelera(id, 'M', 2, 1);
            System.out.println("Manchado " + id + " tira la taza");
            papelera.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
