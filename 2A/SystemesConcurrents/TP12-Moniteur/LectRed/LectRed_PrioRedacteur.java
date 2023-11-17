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
    private Condition peutLire;
    private Condition peutEcrire;

    private int nbLecteurs;
    private int nbEcrivainsEnAttente;
    private boolean isWriting;

    public LectRed_PrioRedacteur() {
        this.mon = new ReentrantLock();
        this.peutLire = mon.newCondition();
        this.peutEcrire = mon.newCondition();
        this.nbLecteurs = 0;
        this.nbEcrivainsEnAttente = 0;
        this.isWriting = false;
    }

    public void demanderLecture() throws InterruptedException {
        mon.lock();
        while (nbEcrivainsEnAttente > 0 || isWriting) {
            peutLire.await();
        }
        nbLecteurs++;
        mon.unlock();
    }

    public void terminerLecture() throws InterruptedException {
        mon.lock();
        nbLecteurs--;
        if (nbLecteurs == 0) {
            peutEcrire.signal();
        }
        mon.unlock();
    }

    public void demanderEcriture() throws InterruptedException {
        mon.lock();
        nbEcrivainsEnAttente++;
        while (nbLecteurs > 0 || isWriting) {
            peutEcrire.await();
        }
        nbEcrivainsEnAttente--;
        isWriting = true;
        mon.unlock();
    }

    public void terminerEcriture() throws InterruptedException {
        mon.lock();
        isWriting = false;
        peutEcrire.signal();
        if (nbEcrivainsEnAttente == 0) {
            peutLire.signalAll();
        }
        mon.unlock();
    }

    public String nomStrategie() {
        return "Stratégie: Priorité Rédacteurs.";
    }
}
