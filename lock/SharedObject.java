package lock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedObject {
    //...
    ReentrantLock lock = new ReentrantLock();
    int counter = 0;

    public void incrementCounter() {
        lock.lock();
        try {
            // Critical section here
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public void decrementCounter() {
        lock.lock();
        try {
            // Critical section here
            counter--;
        } finally {
            lock.unlock();
        }
    }
}