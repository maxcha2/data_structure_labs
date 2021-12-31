package trees;
/**
 * Load a tree from a text file.  Format is line based, with each line
 * consisting of a String for data, followed by two ints indicating if
 * the node has a left child or right child.  (1 is yes, 0 is no).
 * Ordering of nodes is postorder.
 *
 * @author John Donaldson
 * @author Benjamin Kuperman (Spring 2007)
 * @author Alexa Sharp (Fall 2012)
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class TreeLoader {
	public static BinaryTree<String> loadTreeFromFile(String fname) throws IOException {
		Stack<BinaryTree<String>> stack = new Stack<BinaryTree<String>>();
		Scanner scan = new Scanner(new File(fname));
		while (scan.hasNextLine()) {
			String firstLine = scan.nextLine();
			Scanner scan2 = new Scanner(firstLine);
				String data = scan2.next();
				int leftBit = scan2.nextInt();
				int rightBit = scan2.nextInt();
				BinaryTree<String> right = new EmptyTree<String>();
				BinaryTree<String> left = new EmptyTree<String>();
				if (rightBit == 1) {
					right = stack.pop();
				}
				if (leftBit == 1) {
					left = stack.pop();
				}
				ConsTree<String> newBT = new ConsTree<String>(data, left, right);
				stack.push(newBT);
		}
		if (stack.isEmpty() == true) {
			return new EmptyTree<String>();
		}
		if (stack.size() == 1) {
			return stack.pop();
		}
		else {
			throw new IOException();
		}
	}
}	
