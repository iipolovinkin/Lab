package ru.blogspot.feomatr.lab.patterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
//        final Image image1 = new ProxyImage("HiRes_10MB_Photo1");
//        Image realImage = new RealImage("123");

//        realImage.displayImage();
//        final Image image2 = new ProxyImage("HiRes_10MB_Photo2");

//        image1.displayImage(); // loading necessary
//        image1.displayImage(); // loading unnecessary
//        image2.displayImage(); // loading necessary
//        image2.displayImage(); // loading unnecessary
//        image1.displayImage(); // loading unnecessary


        final Image image3 = new ProxyRemoteImage("HiRes_10MB_Photo2");
        image3.displayImage();
    }
}
