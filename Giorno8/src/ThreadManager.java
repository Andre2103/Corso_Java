
public class ThreadManager {
	
	static class MyRunn implements Runnable {
		
		@Override
		public void run() {
			
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				
				e.printStackTrace();
			}
			
			System.out.println("Io sono il tuo primo Thread");
		}
	}
	
	static class MyRunn2 implements Runnable{
		
		@Override
		public void run() {
			
			System.out.println("Io sono il tuo secondo Thread");
		}
	}

	public static void main(String[] args) {
		
		Thread t = new Thread(new MyRunn(), "Nome Thread 1");
		Thread t2 = new Thread(new MyRunn2(), "Nome Thread 2");

		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();
	}
}
