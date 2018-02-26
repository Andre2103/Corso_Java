
public class Stringhe {

	public static void main(String[] args) {
		
		
		String Frase = "Ciao a tutti!";
		// Costruisco due oggetti e copio il
		// contenuto di uno nell'altro.
		StringBuilder sb = new StringBuilder(Frase); 
	    //Inverto 
		sb.reverse();
		
		//Faccio tornare sb una stringa e la stampo
		System.out.println(sb.toString());
	    
		
		
	}

}
