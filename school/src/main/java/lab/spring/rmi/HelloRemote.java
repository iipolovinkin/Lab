package lab.spring.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloRemote extends Remote {
    String sayHello(String greeting) throws RemoteException;
}
