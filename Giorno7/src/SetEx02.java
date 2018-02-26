import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SetEx02 {
	
	Set<Double> vals = null;
	
	public SetEx02() {
		vals = new HashSet<Double>();
	}
	
	public boolean put(double val) {
		// Inserire elemento val, ritorna true se l'inserimento va a buon fine
		// altrimenti false
		if(val<0)
			return false;
		
		vals.add(val);
		return true;
	}
	
	public int getSize() {
		// Ritorna il numero di elementi contenuti nel set
		
		return vals.size();
	}
	
	public Set<Double> getMoreThen(double val) {
		// Ritorna set contenente solo i valori maggiori di val
		
		Set<Double> nuovo = new HashSet<Double>();
		
		for(Double va : vals) {
			if(val <= va)
				nuovo.add(va);
		}
		return nuovo;
		
	}
	
	public Map<Double, Integer> getMap(){
		// Ritorna il dizionariocon tutte gli elementi di vals come chiavi 
		// e 0 come valore 
		Iterator it = vals.iterator();
		Map<Double, Integer> maps = new HashMap<Double, Integer>();
		
		while(it.hasNext()){
			maps.put((Double)it.next(), (Integer)0);
		}
		
		return maps;
	}
	
	@Override
	public String toString() {

		// TODO: ritornare la lista di tutti gli elementi e la somma nel formato seguente:
		//			[elem1, elem2, elem3, ..., elemN] = somma
		
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (Double val : vals) {
			sb.append(val + ", ");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		// Inserire 10.000 mila elementi ( NON RIPETUTI )
		// testare metodi
		int valore = 10000;
		SetEx02 l = new SetEx02();
		for (int x=0; x<valore; x++)
			while(!l.put(Math.random()*100)) {}
		System.out.println(l.getSize());
		System.out.println(l.toString());
			
			
			
	}

}
