import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class ProgrammaIO {

	public static void main(String[] args) throws IOException {

		File f = new File("prova");
		if (f.exists()) {
			
			
			
			
			// Versione 1 Leggere
			System.out.println("esiste e c'è scritto:");
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			System.out.println(br.readLine());
			//fis.close(); per chiuedere
			
			
			
			
			//Scriviamo un file 
			
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			PrintWriter pw  = new PrintWriter(osw);
			pw.println("Fuck");
			pw.println("Fuck");
			pw.println("Fuck");
			pw.println("Fuck");
			pw.println("Fuck");
			pw.flush();
			//fos.close(); per chiudere
			
			
			
			
			//Versione 3 legge tutto il foglio
			BufferedReader bur = new BufferedReader(new FileReader("prova"));
			String riga = bur.readLine();
			while(riga!= null) {
				System.out.println(riga);
				riga = bur.readLine();
			}
			// Leggere solo una riga 
			// System.out.println(bur.readLine());
			bur.close();
			
			
			
		}
			
		else
			System.out.println("Non esiste");
		
		
		
	}

}
