package superes;

public class HeavyLati extends BadLato{

	private static final long serialVersionUID = 156L;

	public HeavyLati(String[] name, double[] valo) {
		super(name, valo);
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "ERRORE! L'area del rettangolo è superiore a 100!";
	}

}
