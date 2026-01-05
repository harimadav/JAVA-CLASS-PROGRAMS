class ThreadDemos extends Thread {
	   private Thread t;
	   private String threadName;
	   ThreadDemos( String name) {
	      threadName = name;
	      System.out.println("Thread: " + threadName + ", " + "State: New");
	   }
	   public void run() {
	      System.out.println("Thread: " + threadName + ", " + "State: Running");
	      for(int i = 4; i > 0; i--) {
	         System.out.println("Thread: " + threadName + ", " + i);
	      }
	      System.out.println("Thread: " + threadName + ", " + "State: Dead");
	   }
	   public void start () {
	      System.out.println("Thread: " + threadName + ", " + "State: Start");
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	}
	public class lifecycle_thread {
	   public static void main(String args[]) {
	      ThreadDemos thread1 = new ThreadDemos( "Thread-1");
	      ThreadDemos thread2 = new ThreadDemos( "Thread-2");
	      thread1.start();
	      thread2.start();
	   }   
	}
