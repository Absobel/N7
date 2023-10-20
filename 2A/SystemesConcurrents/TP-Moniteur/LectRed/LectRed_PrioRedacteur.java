// Time-stamp: <28 oct 2022 09:24 queinnec@enseeiht.fr>

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import Synchro.Assert;

/** Lecteurs/rédacteurs
 * stratégie d'ordonnancement: priorité aux rédacteurs,
 * implantation: avec un moniteur. */
public class LectRed_PrioRedacteur implements LectRed
{
    private Lock mon;
    /* Conditions */
    private Condition estEnTrainDeLire;
    private Condition estEnTrainDEcrire;

    private int nbLecteurs;

    public LectRed_PrioRedacteur() {
        this.mon = new ReentrantLock();
        this.estEnTrainDeLire = mon.newCondition();
        this.estEnTrainDEcrire = mon.newCondition();
        this.nbLecteurs = 0;
    }

    public void demanderLecture() throws InterruptedException {
        mon.lock();
        estEnTrainDEcrire.await();
        nbLecteurs++;
        mon.unlock();
    }

    public void terminerLecture() throws InterruptedException {
        mon.lock();
        nbLecteurs--;
        if (nbLecteurs == 0) {
            estEnTrainDEcrire.signal();
        }
        mon.unlock();
    }

    public void demanderEcriture() throws InterruptedException {
        mon.lock();
        estEnTrainDEcrire.await();
        mon.unlock();
    }

    public void terminerEcriture() throws InterruptedException {
        mon.lock();
        estEnTrainDEcrire.signal();
        mon.unlock();
    }

    public String nomStrategie() {
        return "Stratégie: Priorité Rédacteurs.";
    }
}
