package superes;

public class InsuffLati extends BadLato {

	private static final long serialVersionUID = 156L;

	public InsuffLati(String[] name, double[] valo) {
		super(name, valo);
	}


	@Override
	public String toString() {
		return "ERRORE! L'area del rettangolo è inferiore a 0.1!";
	}
}
