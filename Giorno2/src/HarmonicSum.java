
public class HarmonicSum {
	
	public static void main(String[] args) {
		
		double sum = 0;
		int n=50000; 
		
		for (double i = 0; i < n; i++)
			sum = sum + 1/(i+1);
		
		System.out.println("Da sinistra a destra e' "+sum);
		
		sum = 0;
		for (double i = n; i > 0; i--)
			sum = sum + 1/(i+1);
		
		System.out.println("Da destra a sinistra " + sum);
	}

}
