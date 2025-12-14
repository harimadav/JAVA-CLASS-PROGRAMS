package THREAD;
//Example of Multithreading using Thread class
class yThread extends Thread {
 public void run() {
     for (int i = 1; i <= 3; i++) {
         System.out.println(Thread.currentThread().getName() + " - Count: " + i);
         try {
             Thread.sleep(500); // pause for half second
         } catch (InterruptedException e) {
             System.out.println(e);
         }
     }
 }
}

public class multithreading {
 public static void main(String[] args) {
     yThread t1 = new yThread();
     yThread t2 = new yThread();

     t1.setName("Thread-1");
     t2.setName("Thread-2");

     // Starting both threads
     t1.start();
     t2.start();
 }
}


