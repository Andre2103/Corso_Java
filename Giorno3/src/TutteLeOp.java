
public class TutteLeOp {

	
	static class MyMet{
		int x,y;
		
		public MyMet(){}
		
		public MyMet(int x, int y) {
			
			this.x = x;
			this.y = y;
		}
		
		public void dif () {
			int tot= x - y;
			System.out.println("La differenza è" + tot);
			return;
		}
		
		public void sum () {
			int tot = x + y;
			System.out.println("La somma è " + tot);
			return;
		}
		
	}
	
	public static void main(String[] args) {
		
		MyMet i = new MyMet(5,6);
		i.dif();
		i.sum();

	}
	
	void sum (int x, int y) {
		
		int tot= x + y;
		System.out.println("La somma è" + tot);
		return;
				
	}
	
	
	
	

}
