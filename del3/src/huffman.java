
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class huffman {
	static int ctr;
	static ArrayList<Integer> frequencies = new ArrayList<>(); 
	
	public static void main(String[] args) throws Exception {
		doFrequencies(args);
		
		//initialize n and Q as BUILD MIN HEAP
		int n = (frequencies.size()/2);
		PQ Q = new PQHeap(n);
		Iterator<Integer> f = frequencies.iterator();
		while (f.hasNext()) { 
			Q.insert(new Element(f.next(), f.next())); 
		}
		
		//for loop that inserts z with frequency/key as sum of two lowest in Q
		Element x;
		Element y;
		for (ctr = 0; ctr <= (n-1); ctr++) {
			x = Q.extractMin();
			y = Q.extractMin();
			Element z = new Element(x.key + y.key, null);
			Q.insert(z); 
		}
	}
	
// makes arraylist with frequencies of different characters as ascii in the input file
	public static void doFrequencies(String[] args) throws Exception {
		int i;
		Map<Integer, Integer> tempMap = new HashMap<> ();

		FileInputStream inFile = new FileInputStream(args[0]);

		Reader in = new InputStreamReader(inFile, "UTF-8");
		
		while ((i = in.read()) != -1) {
			if (tempMap.get(i) != null) {
				tempMap.put(i, tempMap.get(i) + 1);
			}
			else {
				tempMap.put(i, 1);
			}
		}
		in.close();
	
		for (Entry<Integer, Integer> entry : tempMap.entrySet()) {
			frequencies.add(entry.getValue());
			frequencies.add(entry.getKey());
		}
	}
}
