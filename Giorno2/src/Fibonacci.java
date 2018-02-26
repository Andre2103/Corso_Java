
public class Fibonacci {

	public static void main(String[] args) {
		
		int n = 2,
			ciclo = 20,
			tot = 0;
			
		
		for (int i=0; i<ciclo; i++) {
			tot = tot + (n-1) + (n-2);
			System.out.print(tot + " ");
			n++;

		}

	}

}
