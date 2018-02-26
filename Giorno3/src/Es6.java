
public class Es6 {
	
	public static class OperArr{
		
		static int[] myInt = {1,1,1,1};
		
		public static Integer mulSum(int mul){
			
			if(myInt == null)
				return null;
			
			int sum = 0;
			int calc;
			
			for(int val: myInt) {
				calc = val * mul;
				sum = sum + calc;
			}
			
			return sum;
		}
		
	}

	public static void main(String[] args) {
		
		int result = OperArr.mulSum(5);
		System.out.println(result);

	}

}
