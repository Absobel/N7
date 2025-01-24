package daemon;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import interfaces.KV;

public interface RunMap extends Remote, Serializable {
    public KV[] runMap (String fname) throws RemoteException;
}
