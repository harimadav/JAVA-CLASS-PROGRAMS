package THREAD;

//Step 1: Implement Runnable
class MyRunnable implements Runnable {
 public void run() {
     System.out.println("Thread is running using Runnable");
 }
}

public class thread_creation_using_runnable_interface {
 public static void main(String[] args) {
     // Step 2: Create Runnable object
     MyRunnable r = new MyRunnable();

     // Step 3: Pass Runnable to Thread
     Thread t = new Thread(r);

     // Step 4: Start the thread
     t.start();
 }
}


