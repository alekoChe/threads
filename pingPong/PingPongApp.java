package pingPong;

public class PingPongApp {

    public static void main(String[] args) {
        /** 1. Реализовать программу, в которой два потока поочередно пишут ping и pong. */

        Object monitor = new Object();

        while (true) {
            Thread threadPing = new Thread(() -> {

                try {
                    synchronized (monitor) {
                        System.out.println("Ping");
                        monitor.wait();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw  new RuntimeException();
                }
            });
            threadPing.start();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Thread threadPong = new Thread(() -> {

                synchronized (monitor) {
                    System.out.println("Pong");
                    monitor.notify();
                }
            });
            threadPong.start();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
