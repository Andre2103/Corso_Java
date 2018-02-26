


public class OopEx {

	
	
	static interface FormaGeometrica{
		
		public abstract double getPerim();
		public abstract double getArea();
		
	}
	
	static abstract class Point{
		
		double x, y;
		
		public double getX() {
			return x;
		}
		
		public void setX(double x) {
			this.x = x;
		}
		
		public double getY() {
			return y;
		}
		
		public void setY(double y) {
			this.y = y;
		}
		
		public abstract double getOriginDist();
		
	}
	
	static class Point2D extends Point{
		
		public Point2D(int x, int y) {
			setX(x);
			setY(y);
		}
		
		@Override
		public double getOriginDist() {
			
			return Math.pow(x-0, 2) + Math.pow(y-0, 2);
		}
	}
	
	static class Point3D extends Point{
		
		int z;
		
		public Point3D(int z) {
			this.z = z;
			setX(x);
			setY(y);
		}
		
		public Point3D(Point3D c, int r) {
			
		}
		
	    @Override
	    public double getOriginDist() {
	    	return Math.pow(x-0, 2) + Math.pow(y-0, 2) + Math.pow(z-0, 2);
	    }
	}
	
	static class Circle implements FormaGeometrica{
		
		private Point2D c;
		private double r;
		
		private Circle(int x, int y, int r) {
			
			this.r = r;
			this.c = new Point2D(x,y);
		}
		
		private Circle(Point2D c, int r) {
			
			this.r = r;
			this.c = c;
		}
		
		@Override
	    public String toString() {
	    	return "La dist tra due punti di una SFERA è : " + c.getOriginDist();
	    }
		
		public Point2D getC() {
			return c;
		}

		@Override
		public double getPerim() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getArea() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	static class Sphere extends Circle implements FormaGeometrica {
		
		private Point3D c;
		private double r;
		
		private Sphere(int x, int y, int z, int r) {
			super(x, y, r);
			this.c = new Point3D(z);
		}
		
		private Sphere(Point3D c, int r) {
			this.r = r;
			this.c = c;
		}
		
		@Override
	    public String toString() {
	    	return "La dist tra i punti di una SFERA è : " + c.getOriginDist();
	    }
		
	}
	
	
	public static void main(String[] args) {

		//Point3D p1 = new Point3D (2,6,4);
		Circle c1 = new Circle (2,3,10);
		Sphere c2 = new Sphere (2,3,4,20);
		//Sphere c3 = new Sphere (p1, 4);
		System.out.println(c1.toString());
		System.out.println(c2.toString());

	}

}
