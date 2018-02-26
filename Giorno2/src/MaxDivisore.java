
public class MaxDivisore {

	public static void main(String[] args) {

		int num =(int) (Math.random()*100);
		for (int i=num-1;i>0;i--) {
			
			if(num%i == 0) {
				System.out.println("Max divisore di " + num + " e' " + i);
				i=0;
			}
			
		}
		

	}

}
