
public class ThreadManager2 {
	
	static class MyThread extends Thread{
		
		final String NAME;
		
		public MyThread(String name) {
			
			NAME = name;
			System.out.println("Init Thread " + name);
		}
		
		@Override
		public void run() {
			
			System.out.println("Running Thread " + NAME);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public synchronized void start() {

			System.out.println("Start thread " + NAME);
			super.start();
		}
	}

	public static void main(String[] args) {
		new MyThread ("MyThread");
		

	}

}
