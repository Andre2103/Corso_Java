import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Esercizi {
	
	List<Integer> vals = null;
	
	public Esercizi() {	
		vals = new ArrayList<Integer>(100);
	}
	
	public void put(int index) {
		
		vals.add(index);
	}
	
	public boolean remove(int val) {
		
		// Rimuovere elemento dall indice index
		// Ritorna true se tutto va a buon fine, altrimenti false
		if(val<0)
			return false;
		
		if(val>=vals.size())
			return false;
		
		vals.remove(val);
		return true;
	}
	
	public boolean removeObj(Integer val) {
		
		// Rimuovere elemento dalla lista
		// Ritorna true se tutto va a buon fine, altrimenti false
		if(val == null)
			return false;
		
		return vals.remove(val);
	}
	
	public int findObj(Integer val) {
		
		// Ritornare l'indice delle elemento val o -1 se non trovato
		if(vals == null)
			return -1;
		return vals.indexOf(val);
	}
	
	public int getMax() {
		// Ritornare l'elemento di valore massimo
		if(vals == null)
			return -1;
		return Collections.max(vals);
	}
	
	public int getMaxInd() {
		// Ritornare l'indice dell elemento di valore massimo
		return vals.indexOf(getMax());
	}
	
	public int sum() {
		
		// Ritornare somma di tutti gli elementi
		// VINCOLO: utilizzare ciclo foreach (es: for(Integer val : vals) {...}
		int sum = 0;
		for(Integer val: vals)
			sum += val;
		return sum;
	}

	public int sumIt() {
		
		// TODO: ritornare somma di tutti gli elementi
		// 		VINCOLO: utilizzare iteratore
		int sumit = 0;
		Iterator<Integer> ite = vals.iterator();
		
		while(ite.hasNext()) {
			sumit += ite.next();
		}
		return sumit;
	}
	@Override
	public String toString() {

		// TODO: ritornare la lista di tutti gli elementi e la somma nel formato seguente:
		//			[elem1, elem2, elem3, ..., elemN] = somma
		
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for(Integer val : vals) {
			sb.append(val + ", ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		// TODO: instanziare la nuova classe
		//		 inserire 100 elementi casuali all'interno della lista
		// 		 testare tutti i metodi verificandone la correttezza
		
		Esercizi lista = new Esercizi();
		lista.put(10);
		lista.put(11);
		lista.put(20);
		lista.put(40);
		lista.put(30);
		lista.put(3);
		lista.remove(2);
		lista.removeObj(30);
		System.out.println(lista.getMax());
		System.out.println(lista.getMaxInd());
		System.out.println(lista.findObj(3));
		System.out.println(lista.sum());
		System.out.println(lista.sumIt());
		System.out.println(lista.toString());
		
	}
}
