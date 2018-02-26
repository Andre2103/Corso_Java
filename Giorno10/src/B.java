
public class B {


	public static void main(String[] args) {
		
		String x = "sdfsgfd";
		int y = 5;
		
		try{
			for(int i=x.length(); i>0;i--)  {
				y /= x;
			}
			
		}catch(Exception e) {
			System.out.println(y);
		}

	}

}
