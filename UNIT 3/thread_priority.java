package THREAD;
class My extends Thread {
    My(String name) {
        super(name);  // set thread name
    }

    public void run() {
        System.out.println(getName() + " is running with priority " + getPriority());
    }
}

public class  thread_priority {
    public static void main(String[] args) {
        My t1 = new My("Thread-1");
        My t2 = new My("Thread-2");
        My t3 = new My("Thread-3");

        // Set priorities
        t1.setPriority(Thread.MIN_PRIORITY);  // 1
        t2.setPriority(Thread.NORM_PRIORITY); // 5
        t3.setPriority(Thread.MAX_PRIORITY);  // 10

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}


