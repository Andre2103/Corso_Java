import java.util.ArrayList;
import java.util.List;

public class ConcAccess {
	
	static List<String> msgs = new ArrayList<String>();
	
	static class MyRunn1 implements Runnable{
		
		@Override
		public void run() {
			
			System.out.println("Starting Thread 1");
			
			try {
				
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				
				e.printStackTrace();
			}
			
			synchronized (msgs) {
				
				for(int i=0; i<10 ; i++) {
					System.out.println("Thread 1");
					msgs.add("From Thread 1: iteration " + (i+1));
				
					try {
					
						Thread.sleep(500);
					} catch(InterruptedException e) {
					
						e.printStackTrace();
					}
				}
			}
			
			System.out.println("Ending Thread 1");
		}
	}
	
	static class MyRunn2 implements Runnable{
		
		@Override
		public void run() {
			
			System.out.println("Starting Thread 2");
			
			synchronized (msgs) {
				
				for(int i=0; i<10 ; i++){
					System.out.println("Thread 2");
					msgs.add("From Thread 2: iteration " + (i+1));
				
					try {
					
						Thread.sleep(500);
					} catch(InterruptedException e) {
					
						e.printStackTrace();
					}
				}
			}
			
			System.out.println("Ending Thread 2");
		}
	}

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyRunn1()),
			   t2 = new Thread(new MyRunn2());
		
		t1.start();
		t2.start();
				
		while(t1.isAlive() || t2.isAlive() ) {
			
			try {
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			synchronized (msgs) {
				
				System.out.println("Printing msmg");
				for(String msg : msgs)
					System.out.println(msg);
			}
		}
	}

}
