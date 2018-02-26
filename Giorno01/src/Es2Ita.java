
public class Es2Ita {

	public static void main(String[] args) {
		
		int a = 9;
		int b = 3;
		int cont = 0;
		
		double sum = 0;
		double media;
		
		if(a>b) {
			
			while (a>=b) {
				sum = sum + b;
				b++;
				cont++;
			}
			media = sum / cont;
			System.out.println(sum);
			System.out.println(media);
			
		}

	}

}
