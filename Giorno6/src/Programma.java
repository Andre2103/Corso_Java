
public class Programma {
	
	public static int NUMERO_MAX_UTENTI = 10;

	public static void main(String[] args) {

		ClasseA ogg1 = new ClasseA();
		ClasseA ogg2 = new ClasseA();
		
		ogg1.setCampoA("Valore in ogg1");
		ogg2.setCampoA("Valore in ogg2");
		
		System.out.println(ogg1.getCampoA());
		System.out.println(ogg2.getCampoA());
	}

}
