
public class Es3 {
	
	public static class Evvai{
	
		static Integer FindElem(int[] arr, int elem) {
		
			if(arr == null)
				return null;
		
			for(int i=0; i<arr.length; i++) {
			
				if(arr[i] == elem) {
					return i;
				}
			}
		return -1;
		
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 4, 6, 10};
		Integer ris = new Integer(0);
		ris = Evvai.FindElem(arr, 4);
		System.out.println(ris);

	}
}
