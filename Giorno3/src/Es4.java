
public class Es4 {
	
	public static class FunzArr{
		
		public static int[] conc(int[] arr1, int[] arr2) {
			
			if(arr1 == null || arr2 == null)
				return null;
			
			int grand = arr1.length + arr2.length;
			int [] ris = new int [grand];
			int j = 0;
			for(int i=0; i<grand; i++) {
				
				if(i<arr1.length)
					ris[i] = arr1[i];
				
				else {
					ris[i] = arr2[j];
					j++;
				}
				
			}
			
			return ris;
		}
		
	}

	public static void main(String[] args) {
		
		int[] arr1 = {1,4,5,6,7};
		int[] arr2 = {6,3,8,5};
		int[] ris = FunzArr.conc(arr1, arr2);
		
		for(int val: ris)
			System.out.print(val + " ");

	}

}
