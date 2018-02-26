package superes;
import javax.management.BadAttributeValueExpException;

public class Abstract1 {
	
	// Creare classe astratta BadGeomAttribute 
	// - che estende BAEE 
	// - implementare un mess di default (getMessage())
	// - serialVersionUID = 156L;
	// - implementare un costruttore che accetti in ingresso il nome del parametro errato (stringa) e il valore (double)
	// Creare classe BadRaggio che estende BadGeomAttribute
	// creare classe BadLato che estende BadGeomAttribute
	// creare classe InsuffRaggio che estende BadGeomAttribute dal lanciare nel caso in cui dato il raggio l'area del
	//     del cerchio sia inferiore a 0.1
	// Creare classe HeavyRaggio che estende BadRaggio da lanciare nel caso in cui dato il raggio l'area sia su a 100
	// creare classi InsuffLati e HeavyLati che seguono la logica del cerchio applicata alla classe rect

	
	abstract static class FormaGeometrica{
		
		public abstract double getPerim();
		public abstract double getArea();
		
	}
	
	static class Cerchio extends FormaGeometrica{
		
		// rappresentare autonomamente la classe cerchio consistente
		// con la realtà analizzata
		
		// Implementare Setter e Getter di tutte le variabili di istanza
		
		// Implementare inoltre una versione consistente nei metodi 
		// equals e to string  
		
		private double r;
		
		public Cerchio (double r) throws BadAttributeValueExpException {
			
			setX(r);
		}
		
		@Override
		public double getArea() {

			return r*r*Math.PI;
		}
		
		@Override
		public double getPerim() {

			return 2*r*Math.PI;
		}
		
		public double getX() {
			
			return r;
		}
		
		public void setX(double r) throws BadRaggio {
			
			if(r<0)
				throw new BadRaggio(r);
			this.r = r;
			
			if(getArea() < 0.1)
				throw new InsuffRaggio(r);
			
			if(getArea() > 100)
				throw new HeavyRaggio(r);
		}
		
	}
	
	static class Rect extends FormaGeometrica {
		
		// rappresentare autonomamente la classe cerchio consistente
		// con la realtà analizzata
		
		// Implementare Setter e Getter di tutte le variabili di istanza
		
		// Implementare inoltre una versione consistente nei metodi 
		// equals e to string 
		
		double x,
		       y;
		
		public Rect (double x, double y) throws BadAttributeValueExpException {
			
			if(x*y < 0.1)
				throw new BadLato(x,y);
			
			setX(x, y);
			
		}
		
		@Override
		public double getArea() {
			
			return x * y;
		}
		
		@Override
		public double getPerim() {

			return x + y;
		}
		
		public double getX() {
			
			return x;
		}
		
		public double getY() {
			
			return y;
		}
		
		public void setX(double x, double y) throws BadLato {
			if(x<0 || y<0)
				throw new BadLato(x,y);
			
			this.x = x;
			this.y = y;
		}
		
	}
	
	static double sumPerim(FormaGeometrica f1, FormaGeometrica f2) {
		
		return f1.getPerim() + f2.getPerim(); 
		
	}
	
	static double sumArea(FormaGeometrica f1, FormaGeometrica f2) {
		
		return f1.getArea() + f2.getArea();
	}
	
	
	public static void main(String[] args) {

		Cerchio c2 = null;
		Rect r2 = null;
		
		try {
			c2 = new Cerchio (0d);
			r2 = new Rect (-3d,6d);
			
		} catch (BadAttributeValueExpException e) {
			
			System.out.println(e.getMessage());
		}
		
		if(c2 != null)
			System.out.println("Area: " + c2.getArea());
		if(r2 != null)
			System.out.println("Area: " + r2.getArea());
		if(c2 != null)
			System.out.println("Per: " + c2.getPerim());
	}

}
