package lock;

public class SharedObjectApp {

    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();
        SharedObject2 sharedObject2 = new SharedObject2();

        int count = 0;
        while (count < 100000) {
            Thread thread1 = new Thread(() -> {

                sharedObject.incrementCounter();
            });
            thread1.start();

            Thread thread2 = new Thread(() -> {

                sharedObject.decrementCounter();
            });
            thread2.start();

            Thread thread3 = new Thread(() -> {

                sharedObject2.counter++;
            });
            thread3.start();

            Thread thread4 = new Thread(() -> {

                sharedObject2.counter--;
            });
            thread4.start();

            count++;
        }
        System.out.println(sharedObject.counter);
        System.out.println(sharedObject2.counter);

    }
}
