// Scrivere funzione che genera 10 num casuali tra 0 e 100.
// Stampa valore massimo
public class Da1A100 {

	public static void main(String[] args) {
		
		int max = -1;
		for (int j=0; j<10; j++) {
			
			int buf = (int) (Math.random() *100);
			
			max = Math.max(buf, max);
			
		}
		
		System.out.println(max);
		
		int Max2 = -101;
		int ca= 0;
		for (int k=0; k<10; k++) {
			
			ca = (int) (Math.random()*(-100));
			Max2 = Math.max(ca, Max2);
			System.out.println(ca);
			
		}
		System.out.println(Max2);
		

	}

}
