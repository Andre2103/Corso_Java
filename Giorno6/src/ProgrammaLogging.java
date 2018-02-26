import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ProgrammaLogging {

	public static void main(String[] args) {
		
		LogManager.getLogManager()
			.getLogger(Logger.GLOBAL_LOGGER_NAME)
				 .setLevel(Level.ALL);
		
		Logger log = Logger.getLogger("ProgrammaLogging");

		log.info("Inizio programma");
		
		int a = 0;
		int b= 3;
		a++;
		
		log.fine("a: "+ a + " b: " + b);
		
		int somma = a + b;
		
		log.info("Somma: "+ somma);
		
		log.log( Level.INFO, "Fine Programma");
	}

}
