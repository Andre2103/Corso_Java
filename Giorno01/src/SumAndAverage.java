
public class SumAndAverage {

	public static void main(String[] args) {
		
		double sum = 0;
		double average = 0;
		
		for (int i=0;i<100;i++) {
			
			sum = sum + (i+1);
			
		}
		System.out.print("La somma e' ");
		System.out.println(sum);
		
		average = sum / 100;
		
		System.out.print("La media e'");
		System.out.println(average);

	
		int i=0;
		sum = 0;
		average = 0;
		while (i<100) {
			sum = sum + (i+1);
			i++;
		}
		
		System.out.print("La somma e' ");
		System.out.println(sum);
		
		average = sum / 100;
		
		System.out.print("La media e'");
		System.out.println(average);
	
	}

}
