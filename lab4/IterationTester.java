/** This opens a textfile whose name is given by args[0] and
    makes a list of the unique words in the file.  The algorithm is
    simple: at each step it gets  the next word in the file,d asks if
    the list of  unique words contains it, and if not adds it to the list.
    This is done 3 times: once with Java's ArrayList, once with MyLinkedList
    where the contains method uses and iterator to walk through the elements
    irvthe list, and once with MyLinkedList where contains uses get(i) to
    walk through the list.  It prints the times each pass takes.
**/ 
   
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

		
public class IterationTester {

	public static boolean contains_iteration(MyLinkedList<String> list, String word) {
		Iterator<String> it = list.myIterator();
		while (it.hasNext()) {
			String w = it.next();
			if (word.equals(w))
				return true;
		}
		return false;
	}

	public static boolean contains_index(List<String> list, String word) {
		int i = 0;
		while (i < list.size()) {
			String w = list.get(i);
			if (word.equals(w))
				return true;
			else i += 1;
		}
		return false;
	}
	
	public static void  PrintList(List<String> list) {
		int counter = 0;
		for(String w: list) {
			counter += 1;
			System.out.printf( "%5d. %s\n",  counter, w);
		}
	}
	
	public static void main( String [ ] args ) {
		Scanner words=null;
		long time = 0;
		try {
			words = new Scanner( new File(args[0]) );
		} catch(FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		}
				// TEST 1
		ArrayList<String> aList = new ArrayList<String>();
		long start = System.currentTimeMillis();
		int totalWords = 0;
		while (words.hasNext()) {
			totalWords += 1;
			String w = words.next();
			if (!contains_index(aList, w)) {
				aList.add(w);
			}
		}
		time = System.currentTimeMillis() - start;

		System.out.printf( "File: %s with %d total words.\n", args[0], totalWords);
		System.out.printf( "The ArrayList took %d milliseconds.\n", time);
		System.out.printf("It found %d unique words.\n",  aList.size());
		System.out.println( "Do you want to see them?");
		System.out.print( "y or n: ");
		Scanner user = new Scanner(System.in);
		String response = user.next();
		if (response.equals("y")) {
			PrintList(aList);
		}
		// TEST 2
		MyLinkedList<String> list = new MyLinkedList<String>();
		try {
			words = new Scanner( new File(args[0]) );
		} catch(FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		}
			start = System.currentTimeMillis();
		while (words.hasNext()) {
			String w = words.next();
			if (!contains_iteration(list, w)) {
				list.add(w);
			}
		}
		time = System.currentTimeMillis() - start;

		System.out.printf( "Iteration took %d milliseconds.\n", time);
		System.out.printf("It found %d unique words.\n",  list.size());
		System.out.println( "Do you want to see them?");
		System.out.print( "y or n: ");
		user = new Scanner(System.in);
		response = user.next();
		if (response.equals("y")) {
			PrintList(aList);
		}
		// TEST 3
		list = new MyLinkedList<String>();
		try {
			words = new Scanner( new File(args[0]) );
		} catch(FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		}
			start = System.currentTimeMillis();
		while (words.hasNext()) {
			String w = words.next();
			if (!contains_index(list, w)) {
				list.add(w);
			}
		}
		time = System.currentTimeMillis() - start;

		System.out.printf( "Indexing took %d milliseconds.\n", time);
		System.out.printf("It found %d unique words.\n",  aList.size());
		System.out.println( "Do you want to see them?");
		System.out.print( "y or n: ");
		user = new Scanner(System.in);
		response = user.next();
		if (response.equals("y")) {
			PrintList(aList);

		}
	}
}
