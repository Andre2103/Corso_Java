
public class Vocali {

	public static void main(String[] args) {
		
		String frase = "A";
		int countconso = 0;
		int countvocali = 0;
		int nonlett = 0;
		frase = frase.toLowerCase();
		
		for (int i=0; i<frase.length();i++) {
			
			char lettera = frase.charAt(i);
			
			
			switch (lettera) {
			
			case 'a':
				countvocali++;
				break;
				
			case 'e':
				countvocali++;
				break;
				
			case 'i':
				countvocali++;
				break;
				
			case 'o':
				countvocali++;
				break;
				
			case 'u':
				countvocali++;
				break;
				
			case '1':
				nonlett++;
				break;
				
			case '2':
				nonlett++;
				break;
				
			case '3':
				nonlett++;
				break;
				
			case '4':
				nonlett++;
				break;
				
			case '5':
				nonlett++;
				break;
				
			case '6':
				nonlett++;
				break;
				
			case '7':
				nonlett++;
				break;
				
			case '8':
				nonlett++;
				break;
				
			case '9':
				nonlett++;
				break;
				
			case '!':
				nonlett++;
				break;
				
			case ' ':
				nonlett++;
				break;
				
				default:
					countconso++;
					break;
			}
			
		}
		
		System.out.println("Le vocali sono " + countvocali);
		System.out.println("Le consonanti sono " + countconso);
		System.out.println("Le non lettere sono " + nonlett);
		
		

	}

}
