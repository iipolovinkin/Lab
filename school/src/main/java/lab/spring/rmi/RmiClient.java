package lab.spring.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Клиент rmi. Для работы требуется запустить RmiServerRunner.
 */
public class RmiClient {
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            HelloRemote stub = (HelloRemote) registry.lookup("Hello");
            String response = stub.sayHello("Гость");
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("RmiClient exception: " + e.toString());
            e.printStackTrace();
        }
    }
}