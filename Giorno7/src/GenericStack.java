import java.util.ArrayList;
import java.util.List;

public class GenericStack<E> {
	
	List<E> myStack = new ArrayList<E>();
	
	public int getSize() {
		
		return myStack == null?
				0 : myStack.size();
	}
	
	public E peek() {
		
		if(myStack == null) 
			return null;
		
		return myStack.get(getSize() -1);
	}
	
	public void push(E obj) {
	
		if(myStack == null) 
			return;
		
		myStack.add(obj);
	}
	
	public E pop() {
		
		if(myStack == null) 
			return null;
		
		int lastInd = getSize() -1;
		E obj = myStack.get(lastInd);
		myStack.remove(lastInd);
		
		return obj;
	}
	
	public boolean isEmpty() {
		
		return myStack == null ? true : myStack.isEmpty();
	}
	
	public String toString() {
		
		return myStack == null ? "null" : myStack.toString();
	}

	public static void main(String[] args) {
		
		GenericStack<Integer> ms = new GenericStack<>();
		ms.push(1);
		ms.push(10);
		ms.push(50);
		ms.push(22);
		
		System.out.println("Actual stack: " + ms.toString());
		System.out.println("Get element: " + ms.peek());
		System.out.println("Last element: " + ms.pop());
		System.out.println("Last element: " + ms.pop());
		System.out.println("Last element: " + ms.pop());
	}

}
