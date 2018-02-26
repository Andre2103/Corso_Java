
public class PrintNumberInWord {

	public static void main(String[] args) {
		
		int number = 3;
		
		if(number == 1) {
			System.out.println("ONE");
		}
		
		else if(number == 2) {
			System.out.println("TWO");
		}
		
		else if(number == 3) {
			System.out.println("THREE");
		}
		
		else if(number == 4) {
			System.out.println("FOUR");
		}
		
		switch(number) {
		
		case 1:
			System.out.println("ONE");
			break;
			
		case 2:
			System.out.println("TWO");
			break;
			
		case 3:
			System.out.println("THREE");
			break;
			
		case 4:
			System.out.println("FOUR");
			break;
			
		}

	}

}
