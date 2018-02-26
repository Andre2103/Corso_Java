
public class ArrayEMetodi {
	
	static class ArrEs {
		
		int[] intArr = { 3, 5, 10, 15, 20 };
		
		
		void es1() {
			
			System.out.println("Hello");
			
		}
		
		
		void es2() {
			
			for (int i=0; i< intArr.length; i++)
				System.out.println("Alla posizione " + i + " c'è "+ intArr[i]);
			return;
		}
		
		
		void es3() {
			
			for (int val:intArr)
				System.out.println(val);
			return;
		}
		
		public double somma(double x, double y) {
			
			double tot = x + y;
			return tot;
			
		}
		
		
		public ArrEs() {
			
			es2();
			es3();
			
		}
		
		
		public static void main(String[] args) {
			
			ArrEs es = new ArrEs();
			es.es2();
			es.es3();
			double ris = es.somma(4.5 , 5.0);
			System.out.println(ris);
			
		}
	
	}

}
