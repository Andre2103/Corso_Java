public class Es7 {
	
	public static class Cerchio{
		
		double val;
		
		@Override
		public boolean equals(Object obj) {
			
			if(!(obj instanceof Cerchio))
				return false;
			
			Cerchio c = (Cerchio) obj;
			return c.SameR(this.val);
		}
		
		@Override
		public  String toString() {
			// TODO Auto-generated method stub
			return "AREA: " + getArea() + " PERIMETRO "+ getPerim();
		}
		
		public boolean SameR (double r) {
			
			return r == this.val;
			
		}
		
		public Cerchio(double val) {
			
			this.val = val;
		}
		
		public double getPerim() {
			
			double ris = 2*val*Math.PI;
			return ris;
		}
		
		public double getArea() {
			
			double ris = val*val*Math.PI;
			return ris;
		}
	}
	
	public static class MathCerchio{
		
		
	    public static double getSumPermi (Cerchio a, Cerchio  b) {
			
			double risul = a.getPerim() + b.getPerim();
			return risul;
		}
	    
public static double getSumArea (Cerchio a, Cerchio  b) {
			
			double risul = a.getArea() + b.getArea();
			return risul;
		}
	}

	public static void main(String[] args) {
		
		Cerchio cer = new Cerchio (7.9);
		cer.getArea();
		cer.getPerim();
		System.out.println(cer.toString());
		System.out.println("è uguale? "+cer.SameR(7.9));
		
		Cerchio a = new Cerchio (3.5);
		Cerchio b = new Cerchio (5.6);
		
		System.out.println("Somma perimetro " + MathCerchio.getSumPermi(a, b));
		System.out.println("Somma area " + MathCerchio.getSumArea(a, b));

	}
}
