package lab.spring.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiRunner {
    public static void main(String[] args) {
        try {
            ServerImpl obj = new ServerImpl();
            HelloRemote stub = (HelloRemote) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = getRegistry(true);
            registry.bind("Hello", stub);
            System.out.println("registry = " + registry);
            registry.unbind("Hello");
            UnicastRemoteObject.unexportObject(obj, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Registry getRegistry(boolean inMemoryRegistry) throws RemoteException {
        if (inMemoryRegistry) {
            return LocateRegistry.createRegistry(1099);
        } else {
            //          start rmiregistry -J-D-java.rmi.server.codebase=file:///C:\IT\projects\github\Lab\school\target\school-0.0.1-SNAPSHOT.jar
            return LocateRegistry.getRegistry();
        }
    }
}
