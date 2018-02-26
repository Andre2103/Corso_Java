package superes;

public class BadLato extends BadGeomAttribute {

	private static final long serialVersionUID = 156L;

	public BadLato(double x, double y) {
		super(null);
		for(int i=0; i<name.length; i++) {
			this.name[i] = x + "";
			this.valo[i] = y;
		}
	}
	
	public BadLato(String[] name, double[] valo) {
		super(null);
	}


	
	@Override
	public String getMessage() {

		String res = "Bad rect: ";
		for(int i=0; i<name.length; i++)
			res += (name[i] + " " + valo[i]);
		return res;
	}
	
	

}
