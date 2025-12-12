package THREAD;
class SharedNumber {
    int number;
    boolean available = false;

    synchronized void produce(int num) {
        while (available) {
            try { wait(); } catch (InterruptedException e) {}
        }
        number = num;
        System.out.println("Produced: " + number);
        available = true;
        notify();
    }

    synchronized void consume() {
        while (!available) {
            try { wait(); } catch (InterruptedException e) {}
        }
        System.out.println("Consumed: " + number);
        available = false;
        notify();
    }
}

public class inter_thread_commucation_synchrosized {
    public static void main(String[] args) {
        SharedNumber sn = new SharedNumber();

        // Producer Thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                sn.produce(i);
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                sn.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}


