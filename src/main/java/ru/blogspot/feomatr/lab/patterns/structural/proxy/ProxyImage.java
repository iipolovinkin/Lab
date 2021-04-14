package ru.blogspot.feomatr.lab.patterns.structural.proxy;

public class ProxyImage implements Image {
    private final String filename;
    private RealImage image;

    public ProxyImage(final String filename) {
        this.filename = filename;
    }

    public void displayImage() {
        // ленивая иницивлизация
        if (image == null) {
            image = new RealImage(filename);
        }

        // контроль доступа, логирование обращений
        System.out.println("-----Check\\Log access image: " + filename);

        image.displayImage();

    }

}
