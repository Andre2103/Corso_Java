import java.util.ArrayList;
import java.util.List;

public class ThreadEx02 {
	
	// Thread 1: svuota una lista contenente delle stringhe e stampa il contenuto a video
	// Thread 2: Inserire 10 elementi stringa all'interno della lista ( val casuali da 0 e 10 )
	// Main : Lancia i due thread e ne attende la fine dell'esecuzione;
	//        informa a video che i thread hanno completato il  lavoro e esce
	
	static private List<String> queue = null;
	
	static class FillerRunn implements Runnable{
		
		@Override
		public void run() {
				
			for (int i=0; i<10; i++) {
				String stringa = (int) (Math.random() * 10) + "";
				synchronized (queue) {
					queue.add(stringa);
					System.out.println("THREAD 1: Pos " + (i+1) +": " + stringa);
				}
			
				/* try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} */
			} 
		}
	}
	
	static class EmptierRunn implements Runnable{
		
		
		@Override
		public void run() {
			
			int canc = 0;
			while(canc < 10) {			
				
				if(queue.isEmpty()) {
				}
				else {
					
					synchronized (queue) {
						System.out.println("THREAD 2: Ho rimosso riga che ha valore " + queue.get(0));
						queue.remove(0);
						canc++;
					}
					/* try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Thread tf = new Thread(new FillerRunn()),
			   te = new Thread(new EmptierRunn());
		
		queue = new ArrayList<String>();
		
		tf.start();
		te.start();
	}

}
