
public class PizzaEater {
	
	static Integer sliceOfPizza = null;
	static Integer eatedOfPizza = null;
	
	static class Eater implements Runnable {
		
		@Override
		public void run() {
			
			System.out.println("Entro al ristorante");
			
			
			while(sliceOfPizza < 1) {
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Attento la pizza");
				
			}
			
			while(sliceOfPizza > 0) {
				
				sliceOfPizza--;
				eatedOfPizza++;
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Mangio la fetta di pizza");
				
			}
			
			System.out.println("Pago il conto per " + eatedOfPizza/4 + " pizze ed esco.");
			
		}
		
	}

	static class Waitress implements Runnable{
		
		@Override
		public void run() {
			
			System.out.println("Inizio lavoro cameriere");
			
			int x=0;
			while(x<10) {
				if(sliceOfPizza<2) {
					synchronized (sliceOfPizza) {
						sliceOfPizza += 4;
						System.out.println("Salve, sono il cameriere e vi porto una pizza");
					}
				}
			}
			
			System.out.println("Fine lavoro cameriere");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Thread eaterT = new Thread(new Eater()),
			   waitressT = new Thread(new Waitress());
		
		System.out.println("Inizio lavoro pizzeria");
		eaterT.start();
		waitressT.start();
	}

}
