
/*
 * By:
 * 		Phillip Geisler 		-	phgei15
 * 		Rasmus Bang Poulsen 	-	rapou15
 */

public class PQHeap implements PQ {

	private Element[] priorityQueue;
	private static int last = 1;
	private int i = 0;

	public PQHeap(int maxElms) {
		this.priorityQueue = new Element[maxElms];
		/*for (int i = 0; i < maxElms; i++){
			priorityQueue[i] = new Element(0, null);
		}*/
	}

	//Calculates the index of an index's parent
	private int parent(int index){
		return index/2;
	}
	
	//Calculates the index of a parent's left child
	private int left(int index){
		return 2*index;
	}
	
	//Calculates the index of a parent's right child
	private int right(int index){
		return 2*index+1;
	}
	
	
	/*Min-heapifies the priority queue by finding the smallest key of a parent and its children's keys.
	 * If the smallest isn't the parent's key, the smallest child and the parent is swapped
	 * and a recursive call is made*/
	private void heapify(int index){
		int left = left(index);
		int right = right(index);
		int smallest;
		
		//Checks if the left child is smaller than the parent and assigns the index of the smallest of them to "smallest"
		if (left <= priorityQueue.length-last  && priorityQueue[left].key < priorityQueue[index].key) {smallest = left;}
		else {smallest = index;}
		
		//Checks if the right child is smaller than whoever was smallest above and assigns right to "smallest" if true
		if (right <= priorityQueue.length-last  && priorityQueue[right].key < priorityQueue[smallest].key) {smallest = right;}
		
		//Swaps parent with smallest child if parent isn't smallest and makes recursive call
		if (smallest != index) {
			Element temp = priorityQueue[index];
			priorityQueue[index] = priorityQueue[smallest];
			priorityQueue[smallest] = temp;
			
			heapify(smallest);
		}
	}
	
	//Takes the first element in the ArrayList
	private Element minimum(){
		return priorityQueue[0];
	}

	/*Extracts the first element in the queue into "minimum" and moves the last element to the first position
	 * then it min-heapifies the ArrayList and returns "minimum" */
	public Element extractMin() {
		if (priorityQueue.length-last  < 0) {System.out.println("Error"); }
		
		Element minimum = minimum();
		
		//Moves last element to first position and removes the last position from the queue
		priorityQueue[0] = priorityQueue[priorityQueue.length-last];
		last++;
		
		heapify(0);
		return minimum;
	}
	
	private int tIndex = 0;
	private int index = 0;
	//Inserts an element "e" into the PQ while maintaining a min-heap
	public void insert(Element e) {
		priorityQueue[i] = e;
		i++;
		
		index = tIndex;
		//Maintains the min-heap by swapping an element with its parent, until the parent is smaller
		if(priorityQueue[parent(index)] != null && priorityQueue[index] != null) {
			while (index > 0 && priorityQueue[parent(index)].key > priorityQueue[index].key) {
				Element t = priorityQueue[index];
				priorityQueue[index] = priorityQueue[parent(index)];
				priorityQueue[parent(index)] = t;
				index = parent(index);
			}
		}
		tIndex++;
		index = tIndex;
	}
}
