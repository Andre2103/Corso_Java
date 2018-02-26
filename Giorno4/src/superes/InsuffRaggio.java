package superes;

public class InsuffRaggio extends BadRaggio {

	private static final long serialVersionUID = 156L;

	public InsuffRaggio(double valo) {
		super(valo);
	}
	
	@Override
	public String getMessage() {

		return "ERRORE! L'area del Cerchio � inferiore a 0.1";
	}

}
