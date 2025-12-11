package THREAD;
class DaemonExample extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("Daemon thread is running in background...");
        } else {
            System.out.println("User thread is running...");
        }

        // Simulate work
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class dameon_thread {
    public static void main(String[] args) {
        DaemonExample t1 = new DaemonExample();
        DaemonExample t2 = new DaemonExample();

        // Set t1 as daemon thread
        t1.setDaemon(true);

        t1.start();
        t2.start();
    }
}

