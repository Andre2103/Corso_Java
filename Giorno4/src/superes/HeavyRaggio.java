package superes;

public class HeavyRaggio extends BadRaggio {

	private static final long serialVersionUID = 156L;

	public HeavyRaggio(double valo) {
		super(valo);
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "ERRORE! L'area del cerchio è superiore a 100!";
	}

}
