package lab.patterns0.abstractfactory;

public class Client1 {

    public static void main(String[] args) {


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
        public Car(Body body, Chassis chassis, Window window) {
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
}
