
public class OttoTre {

	public static void main(String[] args) {
		
		int conta=0;
		
		for(int i=0;i<10;i++) {
			int num = (int) (Math.random()*1000);
			num = num -200;
			StringBuilder str = new StringBuilder("" + num);

			for(int j=0;j<str.toString().length();j++) {
				char lett = str.charAt(j);
				if(lett == '8' || lett == '5')
					conta++;
			}
		}
		
		if(conta>5)
			System.out.println("Success");
		
		else
			System.out.println("Fail "+ conta);

	}

}
