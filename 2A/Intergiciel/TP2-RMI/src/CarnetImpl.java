import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarnetImpl extends UnicastRemoteObject implements Carnet {
    private HashMap<String, String> fiches = new HashMap<String, String>();
    private int id;

    public CarnetImpl(int id) throws RemoteException {
        super();
        this.id = id;
    }

    public void Ajouter(SFiche sf) throws RemoteException {
        fiches.put(sf.getNom(), sf.getEmail());
    }

    public RFiche Consulter(String n, boolean forward) throws RemoteException {
        if (fiches.containsKey(n)) {
            return new RFicheImpl(n, fiches.get(n));
        } else if (forward) {
            try {
                Carnet c = (Carnet) Naming
                        .lookup("//" + InetAddress.getLocalHost().getHostName() + "/Carnet" + (id == 1 ? 2 : 1));
                return c.Consulter(n, false);
            } catch (Exception e) {
                System.out.println("CarnetImpl err: " + e.getMessage());
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Fiche non trouvee");
    }

    public static void main(String[] args) {
        int id;
        try {
            id = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Usage: java CarnetImpl <id>");
            return;
        }

        int port = 1099 + id;
        try {
            LocateRegistry.createRegistry(port);
            CarnetImpl c = new CarnetImpl(id);
            String URL = "//" + InetAddress.getLocalHost().getHostName() + ":" + port + "/Carnet" + id;
            Naming.rebind(URL, c);
        } catch (Exception e) {
            System.out.println("CarnetImpl err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
