import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RFicheImpl extends UnicastRemoteObject implements RFiche {
    private String nom;
    private String email;

    public RFicheImpl(String nom, String email) throws RemoteException {
        super();
        this.nom = nom;
        this.email = email;
    }

    public String getNom() throws RemoteException {
        return this.nom;
    }

    public String getEmail() throws RemoteException {
        return this.email;
    }
}
