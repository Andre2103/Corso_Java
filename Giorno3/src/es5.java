
public class es5 {
	
	public static class OpArray{
		
		public static int[] Sott(int[] arr1, int[] arr2) {
			
			if(arr1.length != arr2.length)
				return null;
			
			int[] arrsott = new int[arr1.length];
			
			for(int i=0; i<arr1.length; i++)
				arrsott[i] = arr1[i] - arr2[i];
			
			return arrsott;
			
		}
	}

	public static void main(String[] args) {
		
	int[] arr1 = {1,2,3,4,5};
	int[] arr2 = {1,2,3,4,5};
	int[] ris = OpArray.Sott(arr1, arr2);
	
	for(int val:ris)
		System.out.print(val + " ");

	}
}
