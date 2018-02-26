
public class GenericList<T> {
	
	private T[] myArr = null;
	
	public GenericList(T[] arr) {
		
		this.myArr = arr;
	}
	
	@Override
	public String toString() {
		
		if(myArr == null)
			return "";

		StringBuffer sb = new StringBuffer();
		sb.append("[ ");
		for(T elem : myArr)
			sb.append(elem.toString() + ", ");
		sb.append("]");
		
		return sb.toString();
		
	}

	public static void main(String[] args) {
		
		Integer[] ints = {1,3,6,7};
		Float[] floats = {2.4f, 6.8f, 2.5f};
		String [] strings = {"Hello", "World"};
		
		GenericList<Integer> glInt = new GenericList<Integer>(ints);
		GenericList<Float> glFloat = new GenericList<Float>(floats);
		GenericList<String> glString = new GenericList<String>(strings);
		
		System.out.println(glInt);
		System.out.println(glFloat);
		System.out.println(glString);
		
	}

}
