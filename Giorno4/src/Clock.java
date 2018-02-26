import javax.management.BadAttributeValueExpException;

public class Clock {
	
	// Dare la possibilità di salvare lo stato del tempo in HH:MM.s
	//
	// Fornire i seguenti metodi:
	// void setTime(int,int,int)
	// String getTime()
	// long getTimeInMillis() <-- Ritorna i mm da 00:00.0
	// void tick() <-- incrementa i sec di 1
	// boolean isAM()
	// boolean equals(object)
	// String ToString() <-- stampa l'ora nel formato HH:MM.s ES 01:01.6
	
	// Costruttori
	// default <-- Clock()
	// Clock(int,int,int)
	
	int h, m, s;
	
	public Clock() {
		h = m = s = 0;
	}
	
	public Clock(int h, int m, int s) throws BadAttributeValueExpException {
		
		setTime(h,m,s);
	}
	
	void setTime(int h, int m, int s) throws BadAttributeValueExpException {
		
		if( h<0 || h>23 || m<0 || m>59 || s<0 ||s>59)
			throw new BadAttributeValueExpException("Invalid argument: " +h+m+s);
		
		setH(h);
		setM(m);
		setS(s);
	}
	
	public void tick() {
		
		s++;
		if(s>59) {
			s = 0;
			m++;
		}
		
		if(m>59) {
			m = 0;
			h++;
		}
		
		if(h>23)
			h=0;
	}
	
	public boolean isAM() {
		return h > 11;
	}
	
	public String getTime() {
		
		return getZeroValue(h) + ":" + getZeroValue(m) + ":" + s;
	}
	
	private String getZeroValue(int val) {

		return (val < 10 ? "0" : "") + val;
	}

	public long getTimeInMillis() {
		return (s*(m*60*(h*24)));
	}
	
	public int getH() {
		return h;
	}

	public void setH(int h) {
		String contr = "" + h;
		
		this.h = h;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}
	
	
	
	@Override
	public String toString() {

		return getTime();
	}



	public static void main(String[] args) {

		Clock o = null;
		Clock o1 = null;

		try {
			o = new Clock();
			o1 = new Clock(10,20,30);
		} catch (BadAttributeValueExpException e) {
			
			System.out.println("Bad Clock Value!!!");
		}
		
		if(o != null && o1 != null)
			for (int i=0; i<1000; i++) {
				System.out.println(o1.toString());
				o1.tick();
			}
	}

}
