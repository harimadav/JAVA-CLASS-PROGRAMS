package THREAD;
class Counters {
    static int count = 0;

    // static synchronized method
    static synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " Count: " + count);
    }
}

class onThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            Counters.increment();
            try {
                Thread.sleep(50); // to make output visible
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class mutalexclsuive_synchronized_state {
    public static void main(String[] args) {
        onThread t1 = new onThread();
        onThread t2 = new onThread();

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}


