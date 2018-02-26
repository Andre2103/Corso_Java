import java.io.File;

public class SintassiEVariabili01 { // Dichiarazione di classe

	public static void main(String[] args) { //<--  Dichiarazione di metodo principale
		//individuato dalla JVM quando viene messa in esecuzione 
		//la classe
		
		System.out.println("Ciaoo");
		
		
		//Variabili 
		
		int a= 2;
		
		// Dichiarazione + assegnazione
		
		double b = 10.5;
		
		double c =a+b;
		
		System.out.println(c);
		
		// Esempio
		
		int base = 5;
		int altezza = 10;
		double area = base * altezza / 2;
		System.out.println(area);
		
		String Testo = "Ciaooo";
		
		// String numero = 10; impossibile
		String numero = "Ciao " + 10;
		System.out.println(numero);
		
		File xxx;
		
	}

}
