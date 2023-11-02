import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/* Squelette d'une solution avec un moniteur.
 * Il manque le moniteur (verrou + variables conditions).
 */
public class PhiloMon implements StrategiePhilo {

    // État d'un philosophe : pense, mange, demande ?
    private EtatPhilosophe[] etat;

    private Lock mon = new ReentrantLock();
    private Condition[] peutManger = new Condition[Main.nbPhilosophes];
    private boolean[] isFourchetteLibre = new boolean[Main.nbPhilosophes];

    /****************************************************************/

    public PhiloMon (int nbPhilosophes) {
        this.etat = new EtatPhilosophe[nbPhilosophes];
        for (int i = 0; i < nbPhilosophes; i++) {
            etat[i] = EtatPhilosophe.Pense;

            peutManger[i] = mon.newCondition();
            isFourchetteLibre[i] = true;

        }
    }

    public void demanderFourchettes (int no) throws InterruptedException
    {
        mon.lock();
        etat[no] = EtatPhilosophe.Demande;

        while (!isFourchetteLibre[Main.FourchetteDroite(no)] || !isFourchetteLibre[Main.FourchetteGauche(no)]) {
            peutManger[no].await();
        }
        isFourchetteLibre[Main.FourchetteDroite(no)] = false;
        isFourchetteLibre[Main.FourchetteGauche(no)] = false;

        etat[no] = EtatPhilosophe.Mange;
        // j'ai les fourchette G et D
        IHMPhilo.poser (Main.FourchetteGauche(no), EtatFourchette.AssietteDroite);
        IHMPhilo.poser (Main.FourchetteDroite(no), EtatFourchette.AssietteGauche);
        mon.unlock();
    }

    public void libererFourchettes (int no)
    {
        mon.lock();
        IHMPhilo.poser (Main.FourchetteGauche(no), EtatFourchette.Table);
        IHMPhilo.poser (Main.FourchetteDroite(no), EtatFourchette.Table);
        etat[no] = EtatPhilosophe.Pense;

        isFourchetteLibre[Main.FourchetteDroite(no)] = true; peutManger[Main.PhiloDroite(no)].signal();
        isFourchetteLibre[Main.FourchetteGauche(no)] = true; peutManger[Main.PhiloGauche(no)].signal();
        mon.unlock();
    }

    public String nom() {
        return "Moniteur";
    }

}

