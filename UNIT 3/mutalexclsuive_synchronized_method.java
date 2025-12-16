package THREAD;
class Counte {
    int count = 0;

    // synchronized method ensures only one thread can execute it at a time
    synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " Count: " + count);
    }
}

class MThread extends Thread {
    Counte counte;

    MThread(Counte counte) {
        this.counte = counte;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            counte.increment();
        }
    }
}

public class mutalexclsuive_synchronized_method {
    public static void main(String[] args) {
        Counte counter = new Counte();

        MThread t1 = new MThread(counter);
        MThread t2 = new MThread(counter);

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}


