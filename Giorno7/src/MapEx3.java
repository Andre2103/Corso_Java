import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapEx3 {

	Map<String, Integer> wordCounter = null;
	String str = new String();
	String nomeFile = null;
	
	public MapEx3(String nomeFile) {
		
		this.nomeFile = nomeFile;
	}
	
	public void countWord() throws FileNotFoundException {
		
		// TODO: aprire file all'indirizzo nomeFile
		//			contare le occorrenze di tutte le parole contenute nel file
		//			salvando i dati all'interno del dizionario
		wordCounter = new HashMap<String, Integer>();
		List<String> row = new ArrayList<String>();
		try (FileInputStream fis = new FileInputStream(nomeFile)) {
			try (InputStreamReader isr = new InputStreamReader(fis)) {
				try (BufferedReader br = new BufferedReader(isr)) {
					String r;
					while((r = br.readLine()) != null)
						row.add(r);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for ( String r : row) {
			
			String[] words = r.split(" ");
			for(String w : words)
				if(wordCounter.containsKey(w))
					wordCounter.put(w, wordCounter.get(w)+1);
				else
					wordCounter.put(w, 1);
		}
	}
	
	@Override
	public String toString() {

		// TODO: ritornare rappresentazione dizionario nel formato:
		//			parola --> 10
		//			altraparolea --> 13
		//			... --> ...
		
		StringBuilder sb = new StringBuilder();
		for(String key : wordCounter.keySet())
			sb.append(key + " --> " + wordCounter.get(key) + "\n");
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// TODO: dopo aver genrato un file con testo lorem ipsum (vedi Google)
		//			passare l'indirizzo del file al costruttore della classe corrente
		//			avviare il conteggio di parole
		//			stampare il r
		
		MapEx3 tra = new MapEx3("nomeFile");
		tra.countWord();
		System.out.println(tra.toString());
	}
}