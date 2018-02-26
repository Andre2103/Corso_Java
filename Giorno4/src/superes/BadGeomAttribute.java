package superes;

import javax.management.BadAttributeValueExpException;

public abstract class BadGeomAttribute extends BadAttributeValueExpException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 156L;
	
	String[] name = null;
	double[] valo;
	
	public BadGeomAttribute(String[] name, double[] valo) {
		
		this(null);
		setName(name);
		setValo(valo);
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public double[] getValo() {
		return valo;
	}

	public void setValo(double[] valo) {
		this.valo = valo;
	}

	public BadGeomAttribute(Object val) {
		super(val);
	}
	
	


}
