import java.util.concurrent.locks.ReentrantLock;

//Demonstrating Mutex (ReentrantLock) with multiplication table
class TableMutex {
    private final ReentrantLock lock = new ReentrantLock(); // Mutex lock

    void printTable(int n) {
        lock.lock(); // acquire lock before entering critical section
        try {
            System.out.println("Multiplication Table of " + n);
            for (int i = 1; i <= 10; i++) {
                System.out.println(n + " x " + i + " = " + (n * i));
                try {
                    Thread.sleep(200); // slow down
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println("-----------------------");
        } finally {
            lock.unlock(); // release lock (very important!)
        }
    }
}

//Thread class
class MyThreadMutex extends Thread {
    TableMutex t;
    int number;

    MyThreadMutex(TableMutex t, int number) {
        this.t = t;
        this.number = number;
    }

    public void run() {
        t.printTable(number);
    }
}

public class thread_mutex {
    public static void main(String[] args) {
        TableMutex obj = new TableMutex(); // shared object

        // Create threads for different tables
        MyThreadMutex t1 = new MyThreadMutex(obj, 2);
        MyThreadMutex t2 = new MyThreadMutex(obj, 3);
        MyThreadMutex t3 = new MyThreadMutex(obj, 5);

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}


