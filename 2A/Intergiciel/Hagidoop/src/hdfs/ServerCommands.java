package hdfs;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerCommands extends Remote, Serializable {
    String read(String filename) throws RemoteException;
    void write(String filename, int fmt) throws RemoteException;
    void delete(String filename) throws RemoteException;
}