import java.util.ArrayList;
import java.util.List;

public class ThreadEx3 {
	
	// Thread 1: Inserisci 100 valori interi casuali all interno di list1
	// Thread 2: Prende tutti gli el contenuti in list1 e ne fa una copia da inserire in list2
	// 
	// Thread 1 dopo aver inserito tutti gli elementi la fa somma di tutti gli eleme e la mette in sum1
	// Thread 2 fa lo stesso
	//
	// prima di terminare il main confronta le due somme e informa l'utente se ono uguali o no
	
	static private List<Integer> list1 = null,
			                     list2 = null;
	
	static Integer sum1 = null,
	               sum2 = null;
	
	static class Riempi implements Runnable{
		
		@Override
		public void run() {
			
			int sum = 0;
			
			for(int i=0; i<100; i++) {
				synchronized (list1) {
					list1.add((int) (Math.random()*100));
					sum +=(int) list1.get(i);
				}
			}
			synchronized (sum1) {
				sum1 = sum;
			}
			System.out.println(sum1);
		}
	}
	
	static class Copia implements Runnable{
		
		@Override
		public void run() {
			
			int cc = 0;
			int sum = 0;
			while(cc < 100) {			
				
				if(list1.isEmpty()) {
				}
				else {
					
					for(int i=0; i<list1.size(); i++) {
					
						synchronized (list1) {
							list2.add(list1.get(i));
							sum +=(int) list2.get(i);
							cc++;
						}
					}
					
					synchronized (list2) {
						sum2= sum;
						System.out.println(sum2);
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
		
		Thread rie = new Thread(new Riempi()),
			   cop = new Thread(new Copia());
		
		sum1= 0;
		sum2= 0;
		
		list1 = new ArrayList<Integer>();
		list2 = new ArrayList<Integer>();
		
		rie.start();
		cop.start();
		
		while(rie.isAlive() || cop.isAlive()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if((int)sum1 == (int)sum2)
			System.out.println("Le somme sono uguali");
		else
			System.out.println("non sono uguali");
	}

}
