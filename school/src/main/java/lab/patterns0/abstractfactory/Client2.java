package lab.patterns0.abstractfactory;

public class Client2 {

    public static void main(String[] args) {

        carSelector("car");

    }

    public static void carSelector(String carType) {

        if ("car".equalsIgnoreCase(carType)) {
            workWithCar();
        }
        if ("van".equalsIgnoreCase(carType)) {
            workWithVan();
        }

    }

    private static void workWithCar() {
        Body body = new Body();
        Chassis chassis = new Chassis();
        Window window = new Window();

        Car car = new Car(body, chassis, window);

        car.move();
    }

    private static class Body {
        String getBodyParts() {
            return "bodyParts";
        }
    }

    private static class Chassis {
        String getChassisParts() {
            return "chassisParts";
        }
    }

    private static class Window {
        String getWindowParts() {
            return "windowsParts";
        }
    }

    private static class Car {
        public Car(Client2.Body body, Client2.Chassis chassis, Client2.Window window) {
            System.out.println("body = " + body.getBodyParts());
            System.out.println("chassis = " + chassis.getChassisParts());
            System.out.println("window = " + window.getWindowParts());
            System.out.println();

        }

        public void move() {
            System.out.println("Start");
            System.out.println("...");
            System.out.println("Stop");
        }
    }


    private static void workWithVan() {
        VanBody body = new VanBody();
        VanChassis chassis = new VanChassis();
        VanWindow window = new VanWindow();

        Van van = new Van(body, chassis, window);

        van.move();
    }

    private static class VanBody {
        public String getBodyParts() {
            return null;
        }
    }

    private static class VanChassis {
        public String getChassisParts() {
            return null;
        }
    }

    private static class VanWindow {
        public String getWindowParts() {
            return null;
        }
    }

    private static class Van {
        public Van(VanBody body, VanChassis chassis, VanWindow window) {
            System.out.println("vanBody = " + body.getBodyParts());
            System.out.println("VanChassis = " + chassis.getChassisParts());
            System.out.println("VanWindow = " + window.getWindowParts());
            System.out.println();
        }

        public void move() {
            System.out.println("Start Van");
            System.out.println("Stop Van");
        }
    }
}
