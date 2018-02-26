
public class ControlloDiFlusso2Cicli {

	public static void main(String[] args) {
		
		// Cicli
	
		// For (int i = 0; i < 10; i++){...}
		
		for (int i=0; i<20; i=i+2) {
			System.out.println(i+2);
		}
		
		// ciclo while () {...}
		
		int f=8;
		while( f > 6) {
			System.out.println("Maggiore di 6");
			f--;
		}
		System.out.println("é 6");

	}

}
