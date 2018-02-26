
public class NumeriPrimi {

	public static void main(String[] args) {
		
		boolean primo;
		
		for(int i=0; i<1000;i++) {
			
			primo = true;
			
			for(int j=2;j<i;j++) 
				if(i%j == 0 )
					primo = false;
				
			if(primo)
				System.out.println(i);
				
			
		}

	}

}
