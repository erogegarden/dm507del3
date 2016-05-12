import java.util.ArrayList;
import java.util.Scanner;

/*
 * By:
 * 		Phillip Geisler 		-	phgei15
 * 		Rasmus Bang Poulsen 	-	rapou15
 */

public class Heapsort {
	
	/* Takes an arbitrary number of inputs as it counts the inputs before it creates a new priority queue
	 * with the number of elements. It adds the inputs to a temporary list at the same time.
	 * This is a little inefficient compared to making the user enter the number
	 * of inputs, but makes it possible to input an unknown number of inputs. It then inserts the 
	 */
	public static void main(String[] args) {
		Scanner stdinput = new Scanner(System.in);
		
		ArrayList<Integer> temp = new ArrayList<>(); //A temporary list for the inputs
		
		int maxElms = 0;
		
		/*While loop that goes through the scanner input and counts number of int's inputted
		 * and puts the inputs into the temp list.
		 */
		while (stdinput.hasNext()) {
			if (stdinput.hasNextInt()) {
				temp.add(stdinput.nextInt());
				maxElms++;
			} else {stdinput.next();}
		}
		stdinput.close();
		
		//Initializes an empty priority queue with "maxElms" elements
		PQ pq = new PQHeap(maxElms);
		
		//Goes through each input in the temp list and inserts them into the queue using the insert method
		for (int key : temp) { pq.insert(new Element(key,null)); }

		//Prints the sorted list using the extractMin method
		while ( maxElms > 0) {
			System.out.println(pq.extractMin().key);
			maxElms--;
		}
	}
}