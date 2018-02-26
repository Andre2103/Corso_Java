import java.util.ArrayList;
import java.util.List;

public class ThreadEx4 {
	
	// Thread 1: Inserisce un numero casuale nella lista ogni decimo di secondo
	// Thread 2: Legge la lista, la pulisce e tiene traccia della somma dei valori letti nella lista
	
	static private List<Integer> lista = null;
	static long ms = System.currentTimeMillis();
	
	static class ThreadInser implements Runnable{
		
		@Override
		public void run() {
			
			System.out.println("Inizio");
			
			long deltaMs = System.currentTimeMillis() - ms;
			
			while (deltaMs < 20000) {
				
				 deltaMs = System.currentTimeMillis() - ms;
				 try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lista) {
						lista.add((int) (Math.random()*100));
						System.out.println("Inserito elemento ");
						System.out.println(deltaMs);
					}
			}
		}
	}
	
	static class ThreadLegge implements Runnable{
		
		@Override
		public void run() {
			
			int somma = 1;
			int pulisci = 0;
			
			while(pulisci<200) {
				
				if(lista.isEmpty()) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				else {
					int i=0;
					while(i<lista.size()) {
						somma += (int) lista.get(i);
						synchronized (lista) {
							lista.remove(i);
							System.out.println("Ho eliminato " + pulisci);
						}
						pulisci++;
						i++;
					}
				}
			}
			System.out.println("Somma: " + somma);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		lista = new ArrayList<Integer>();
		
		Thread t1 = new Thread(new ThreadInser());
		Thread t2 = new Thread(new ThreadLegge());
		
		t1.start();
		t2.start();

		
	}

}
