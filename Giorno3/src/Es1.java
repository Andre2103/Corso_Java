
public class Es1 {
	
	
	static class Sum{
		
		public double sum(int[] arr) {
			
			double somma = 0;
			
			for(int val:arr)
				somma = somma + val;
			
			return somma;
			
		}
		
		public void media(int[] arr) {
			
			double media;
			double somma = sum(arr);
			
			media = somma / arr.length;
			
			System.out.println(media);
			
		}
		
		public boolean ThereIsNeg(int[] arr) {
			
			boolean yon = false;
			
			for(int val: arr)
				if(val<0)
					yon = true;
			
			return yon;
		}
		
		public int[] Inverter(int[] arr) {
			
			int[] inve = new int[arr.length];
			int conta = arr.length - 1;
			
			for(int i=0; i<arr.length; i++) {
				
				inve[conta] = arr[i]; 
				conta--;
				
			}
			
			return inve;
			
		}
	
	}

	public static void main(String[] args) {
		
		int[] array = {3, 5, 6, 83, 1, -1, 1};

		Sum ogg = new Sum();
		double somma = ogg.sum(array);
		System.out.println("La somma è " + somma);
		
		ogg.media(array);
		
		boolean ris = ogg.ThereIsNeg(array);
		if(ris)
			System.out.println("Ci sono numeri negativi");
		else
			System.out.println("Non ci sono numeri negativi");
		
		int[] risinve = ogg.Inverter(array);
		
		for(int val:risinve)
			System.out.print(val + " ");
		
	}

}
