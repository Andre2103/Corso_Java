
public class Box<E> {

	private E e;
	
	public void setE (E e) {
		this.e = e;
	}
	
	@Override
	public String toString() {
		return e.toString();
	}
	
	public static void main(String[] args) {

		Box<Integer> b1 = new Box<Integer>();
		b1.setE(10);
		
		Box<String> b2 = new Box<String>();
		b2.setE("Hello");
		
		System.out.println("Out 1 : "+ b1);
		System.out.println("Out 2 : "+ b2);
	}

}
