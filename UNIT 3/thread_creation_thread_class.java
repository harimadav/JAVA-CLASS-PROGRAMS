package THREAD;
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class thread_creation_thread_class{
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();  // Start the thread
    }
}


