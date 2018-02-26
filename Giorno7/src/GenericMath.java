
public class GenericMath {
	
	static <E extends Number> Double sum(E val1, E val2) {
		
		return val1.doubleValue() + val2.doubleValue();
	}

	public static void main(String[] args) {
		
		Double sum1 = GenericMath.sum(new Integer(10), new Integer(30)),
			   sum2 = GenericMath.sum(5.6f, 3.4f);
		
		System.out.println("Somma 1 : " + sum1);
		System.out.println("Somma 2 : " + sum2);
	}

}
