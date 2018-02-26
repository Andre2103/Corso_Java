import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Geom {

	public static abstract class FiguraGeom {

		Map<String, Integer> lati;

		// init from map
		public FiguraGeom(Map<String, Integer> map) {

			this.lati = map;
		}
		
		public class {}

		// calcola perimetro
		public double getPerim() {

			double sum = 0;
			for (String f : lati.keySet()) {
				sum += lati.get(f);
			}
			return sum;

		}

		// calcola area
		public abstract double getArea();

		// restituisce una nuova FiguaraGeom con ogni lato dato dalla somma
		// dei lati dell'istanza corrente con i lati di fg
		// purché l'istanza corrente sia dello stesso tipo di fg
		// null altrimenti
		public abstract FiguraGeom sum(FiguraGeom fg);
	}
	
	public static class Cerchio extends FiguraGeom {
		
		public Cerchio(int rag){
			super(new HashMap<>());
			lati.put("Raggio" , rag);
		}
		
		public Cerchio(FiguraGeom c){
			super(new HashMap<>());
			lati.put("Raggio" , c.lati.get("Raggio"));
		}

		@Override
		public double getArea() {
			
			return Math.PI * Math.pow( lati.get("Raggio") , 2);
		}
		
		@Override
		public double getPerim() {
			return Math.PI * lati.get("Raggio") * 2;
		}

		@Override
		public FiguraGeom sum(FiguraGeom fg) {
			
			if(fg instanceof Cerchio) {
				HashMap<String, Integer> cerMap = new HashMap<>();
				cerMap.put("Raggio", lati.get("Raggio") + fg.lati.get("Raggio")) ;
				return new Cerchio(cerMap.get("Raggio"));
			}
			else
				return null;
		}
	}

	// triangolo rettangolo
	public static class TriangoloRect extends FiguraGeom {

		// init da 3 lati (cateto1, cateto2, ipotenusa)
		public TriangoloRect(int c1, int c2, int ipot) {

			super(new HashMap<>());
			lati.put("c1", c1);
			lati.put("c2", c2);
			lati.put("ipot", ipot);

		}

		// init da mappa
		public TriangoloRect(Map<String, Integer> lati) {

			super(lati);

		}

		@Override
		public double getArea() {

			return (lati.get("c1") * lati.get("c2") / 2);

		}

		@Override
		public FiguraGeom sum(FiguraGeom fg) {

			if (fg instanceof TriangoloRect) {
				HashMap<String, Integer> fgmap = new HashMap<>();
				fgmap.put("c1", (fg.lati.get("c1") + this.lati.get("c1")));
				fgmap.put("c2", (fg.lati.get("c2") + this.lati.get("c2")));
				fgmap.put("ipot", (fg.lati.get("ipot") + this.lati.get("ipot")));

				TriangoloRect r = new TriangoloRect(fgmap.get("c1"), fgmap.get("c2"), fgmap.get("ipot"));

				return r;

			} else
				return null;

		}

		@Override
		public String toString() {

			return ("il nuovo Triangolo rettangolo ha cateto1 " + lati.get("c1") + " cateto 2 " + lati.get("c2")
					+ " ipotenusa" + lati.get("ipot"));
		}
	}

	// rettangolo
	public static class Rect extends FiguraGeom {

		// init da 2 lati (lato1, lato2)
		public Rect(int l1, int l2) {

			super(new HashMap<>());
			lati.put("Base", l1);
			lati.put("Altezza", l2);
		}

		// init da mappa
		public Rect(Map<String, Integer> lati) {

			super(lati);
		}

		@Override
		public double getArea() {

			return (lati.get("Base") * lati.get("Altezza")) / 2;
		}

		@Override
		public FiguraGeom sum(FiguraGeom fg) {

			if (fg instanceof Rect) {
				HashMap<String, Integer> fgmap = new HashMap<>();
				fgmap.put("Base", fg.lati.get("Base") + this.lati.get("Base"));
				fgmap.put("Altezza", fg.lati.get("Altezza") + this.lati.get("Altezza"));
				return new Rect(fgmap);

			} else
				return null;

		}

		@Override
		public String toString() {

			return ("il nuovo rettangolo ha base " + lati.get("Base") + " altezza " + lati.get("Altezza"));
		}
	}

	// triangolo rappresentante della somma di tutti i triangoli
	// inseriti in figure
	static TriangoloRect sumTriang;
	// rettangolo rappresentante della somma di tutti i rettangoli
	// inseriti in figure
	static Rect sumRect;

	// thread che genera casualmente 3 trinagoli seguiti da 2 rettangoli e li
	// mette nella lista di supporto figure
	public static class Generator implements Runnable {

		private boolean c = false;
		
		private List<FiguraGeom> figure = new ArrayList<>();

		@Override
		public void run() {

			c = true;
			while (c) {
				for (int x = 0; x < 3; x++) {

					synchronized (figure) {

						figure.add(new TriangoloRect((int) (Math.random() * 10), (int) (Math.random() * 10),
								(int) (Math.random() * 10)));

					}
				}

				for (int x = 0; x < 2; x++) {

					synchronized (figure) {

						figure.add(new Rect((int) Math.random() * 10, (int) Math.random() * 10));
					}
				}
			
				synchronized (figure) {

					figure.add(new Cerchio((int) Math.random() * 10));
				
				}
			}
		}
		
		public List<FiguraGeom> getList() {
			return figure;
		}

		public void endOfMethod() {
			c = false;
			System.out.println("fine thread generator");
		}

	}

	// estrae tutte le figure nella lista figure e calcola la figura sommata
	// risultante
	// in sumTriang e sumRect
	public static class Summer implements Runnable {

		private boolean c = false;
		Generator g;
		private List<FiguraGeom> figure = new ArrayList<>();
		
		public Summer(Generator g) {
			figure =g.getList();
		}

		@Override
		public void run() {

			c = true;
			Rect sumRect = new Rect(0, 0);
			TriangoloRect sumTriang = new TriangoloRect(0, 0, 0);
			while (c) {

				synchronized (figure) {

					for (FiguraGeom o : figure) {
						if (o instanceof Rect) {

							sumRect = (Rect) sumRect.sum(o);

						}
						if (o instanceof TriangoloRect) {
							sumTriang = (TriangoloRect) sumTriang.sum(o);
						}
					}
				}

			}
			System.out.println("La somma dei triangoli è " + sumTriang + "mentre la somma dei rettangoli è " + sumRect);

		}

		public void endOfMethod() {

			c = false;
			System.out.println("fine thread summer");
		}

	}

	// lancia i due thread, richiede la fine dei lavori ai thread dopo 10s e
	// stampa a video il risultato
	public static void main(String[] args) {
		long ms = System.currentTimeMillis();
		TriangoloRect t1 = new TriangoloRect(2, 4, 8);
		TriangoloRect t2 = new TriangoloRect(1, 2, 4);

		System.out.println(t1.getArea());
		System.out.println(t1.getPerim());
		System.out.println(t1.sum(t2));

		Rect r1 = new Rect(2, 4);
		Rect r2 = new Rect(1, 2);
		System.out.println(r1.getArea());
		System.out.println(r1.getPerim());
		System.out.println(r1.sum(r2));
		
		Cerchio c1 = new Cerchio(18);
		Cerchio c2 = new Cerchio(6);
		System.out.println(c1.getArea());
		System.out.println(c1.getPerim());
		System.out.println(c1.sum(c2));

		Generator g = new Generator();
		Summer s = new Summer(g);
		Thread g1 = new Thread(g);
		Thread s1 = new Thread(s);

		g1.start();
		s1.start();

		while ((System.currentTimeMillis() - ms) < 10000) {

		}
		g.endOfMethod();
		s.endOfMethod();
		
	}
}
