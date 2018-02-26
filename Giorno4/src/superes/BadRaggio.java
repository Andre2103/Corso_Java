package superes;

public class BadRaggio extends BadGeomAttribute {
	
	private static final long serialVersionUID = 156L;
	
	public BadRaggio(double valo){
		
		super(null);
		this.valo =  new double[1];
		this.valo[0] = valo; 
		
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Il raggio " + valo[0] + " non è accettato";
	}


}
