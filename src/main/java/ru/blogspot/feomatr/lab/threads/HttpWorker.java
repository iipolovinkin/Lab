package ru.blogspot.feomatr.lab.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.Socket;

/**
 * @author iipolovinkin
 * @since 01.10.2015
 */
public class HttpWorker implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(HttpWorker.class);
    private String user;
    private String password;
    private String name;
    private String host;
    private int port;

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {


        new Thread(new HttpWorker("name", "user", "password", "yandex.ru", 80)).start();
        new Thread(new HttpWorker("name", "user", "password", "google.ru", 80)).start();
        new Thread(new HttpWorker("name", "user", "password", "javatalks.ru", 80)).start();
        new Thread(new HttpWorker("name", "user", "password", "habrahabr.ru", 80)).start();
        new Thread(new HttpWorker("name", "user", "password", "mail.ru", 80)).start();
    }

    public HttpWorker(String user, String password, String name, String host, int port) {
        this.user = user;
        this.password = password;
        this.name = name;
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        String userpass = user + ":" + password;
        byte[] message = new byte[0];
        try {
            message = userpass.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("", e);

        }
        String encoded = DatatypeConverter.printBase64Binary(message);

        String msg = "GET /" + name + " HTTP/1.1\nUser-Agent: NTRIP\nAuthorization: Basic " + encoded + "\n";

        try {
            // Создаем новый сокет
            Socket socket = new Socket(host, port);
            // Входящий поток
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Исходящий поток
            PrintWriter os = new PrintWriter(socket.getOutputStream(), true);

            // Отправляем сообщение
            os.print(msg + "\n\n");
            os.flush();

            System.out.println("Send:\n" + msg);
            // read a line, assign to c, then compare the new value of c to null
            String c;
            while ((c = is.readLine()) != null) {
                System.out.println(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
