
public class Palindromo {

	public static void main(String[] args) {
		
		String frase = "anna";

		StringBuilder inve = new StringBuilder(frase);
		String nome = inve.reverse().toString();
		if(nome.equals(frase) == true)
			System.out.println("E' palindromo");
		else
			System.out.println("non e' palindromo");
		
		
		System.out.println(nome);
		System.out.println(frase);

	}

}
