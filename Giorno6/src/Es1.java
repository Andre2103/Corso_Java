import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Es1 {

	public static void main(String[] args) throws IOException {
		
		Logger log = Logger.getLogger("Es1");

		File fil = new File("Esercizio1");
		
		if(fil.exists()) {
			log.info("Esiste la pagina");
		
			BufferedReader buf = new BufferedReader(new FileReader("Esercizio1"));
			String riga = buf.readLine();
			int i=1;
			while(riga != null) {
				
				if(i%2 == 0) {
					System.out.println(riga);
					riga = buf.readLine();
					i++;
				}
				riga = buf.readLine();
				i++;
				
			}
			
			buf.close();
		}
		
		
		
	}

}
