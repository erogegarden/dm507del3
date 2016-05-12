
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Treesort uses a scanner to take system.in inputs (inputs from
 * standard input) and adds them into an array list named liste. Then method insert is
 * called for every element in the array list. Afterwards we initialize an array called 'sorted' by calling
 * orderedTraversal and prints out every integer.
 */
public class Treesort {
	public Treesort() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> liste = new ArrayList<>();

		while (scanner.hasNextInt()) {
			liste.add(scanner.nextInt());
		}
		scanner.close();
		Dict dict = new DictBinTree();

		liste.forEach(dict::insert);

		int[] sorted = dict.orderedTraversal();
		for (int i : sorted) {
			System.out.println(i + " ");
		}
	}
}