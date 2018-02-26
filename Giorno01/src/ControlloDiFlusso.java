
public class ControlloDiFlusso {

	public static void main(String[] args) {
		
		// Esecuzione condizionale
		
		
		// IF ELSE
		 int a = 7;
		 
		 if(a < 8){  //Espressione booleana ( True or False )
			 System.out.println("Minore di 8");
		 }
		 else if(a >20){
			 System.out.println("Maggiore di 20");
		 }
		 
		 else {
			 System.out.println("Tra 8 e 20");
		 }
		 
		 // SWITCH() {...}
		 
		 int j = 5;
		 switch (j) {
		 
		 case 1 : // Nel caso x fosse 1.. come scrivere if (x == 1)
			 System.out.println("Vale 1");
			 break;
			 
		 case 2 : 
			 System.out.println("Vale 2");
			 break;
			 
		 case 3 :
			 System.out.println("Vale 3");
			 break;
			 
		 case 4:
		 case 5:
		 case 6:
			 System.out.println("Vale da 4 a 6");
			 break;
			 
			 default : 
				 System.out.println("Valore default");
			 
		 }
		 
		 
		
	}

}
