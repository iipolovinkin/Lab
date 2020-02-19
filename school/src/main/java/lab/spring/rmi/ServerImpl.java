package lab.spring.rmi;

import java.rmi.RemoteException;

public class ServerImpl implements HelloRemote {
    @Override
    public String sayHello(String greeting) throws RemoteException {
        return "Hello " + greeting;
    }
}
