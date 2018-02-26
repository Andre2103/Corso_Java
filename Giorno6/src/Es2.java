import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class Es2 {

	public static void main(String[] args) throws IOException {
		
		int countrighe = 0;
		int countcara = 0;
		Logger log = Logger.getLogger("Es2");
		
		File fi = new File("a.txt");
		
		if(fi.exists()){
			
			BufferedReader bure = new BufferedReader(new FileReader("a.txt"));
			String ri = bure.readLine();
			while(ri != null) {
				
				for(int i=0; i<ri.length(); i++) {
					
					if(Character.isAlphabetic(ri.charAt(i)))
						countcara++;
				}
				
				countrighe++;
				ri = bure.readLine();
			}
			
			bure.close();
			System.out.print("Righe lette: ");
			for(int i=0; i<countrighe; i++) {
				System.out.print("X");
			}
			
			System.out.print(" Caratteri letti: ");
			for(int i=0; i<countcara; i++) {
				System.out.print("Y");
			}
			
		}
		
	}

}
