package foo;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Object monitor = new Object();

        Thread thread1 = new Thread(() -> {
            System.out.println("Start");
            try {
                synchronized (monitor) {
                    System.out.println("Thread1 waiting");
                    monitor.wait();
                    System.out.println("Thread1 is ended");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw  new RuntimeException();
            }
            System.out.println("Stop");
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("Start");
            try {
                synchronized (monitor) {
                    System.out.println("Thread2 waiting");
                    monitor.wait();
                    System.out.println("Thread2 is ended");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw  new RuntimeException();
            }
            System.out.println("Stop");
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            System.out.println("Start");
            try {
                synchronized (monitor) {
                    System.out.println("Thread3 waiting");
                    monitor.wait();
                    System.out.println("Thread3 is ended");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw  new RuntimeException();
            }
            System.out.println("Stop");
        });
        thread3.start();

        Thread.sleep(3000);
        synchronized (monitor) {
            //monitor.notify();
            monitor.notifyAll();
        }
        System.out.println("End of main thread");
    }
}
