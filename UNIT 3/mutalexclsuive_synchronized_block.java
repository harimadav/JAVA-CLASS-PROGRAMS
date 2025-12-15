package THREAD;
class Counter {
    int count = 0;

    void increment() {
        // Only the critical section is synchronized
        synchronized(this) {
            count++;  // critical part
        }
        // This part is outside the synchronized block
        System.out.println(Thread.currentThread().getName() + " Count: " + count);
    }
}

class ownthread extends Thread {
    Counter counter;

    ownthread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            try {
                Thread.sleep(50); // small delay to make interleaving visible
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class mutalexclsuive_synchronized_block {
    public static void main(String[] args) {
        Counter counter = new Counter();

        ownthread t1 = new ownthread(counter);
        ownthread t2 = new ownthread(counter);

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}


