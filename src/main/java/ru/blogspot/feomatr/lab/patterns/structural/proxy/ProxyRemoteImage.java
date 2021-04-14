package ru.blogspot.feomatr.lab.patterns.structural.proxy;

public class ProxyRemoteImage implements Image {
    private final String filename;
    private RemoteService remoteService = new RemoteService();

    public ProxyRemoteImage(final String filename) {
        this.filename = filename;
    }

    public void displayImage() {
//        System.out.println("-----Check\\Log access image: " + filename);
        remoteService.displayImage(filename);

    }

    private static class RemoteService {
        public void displayImage(String fileName) {
            System.out.println("Remote Displaying" + fileName);
        }
    }
}
