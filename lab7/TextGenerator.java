package lab7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int K = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		String fName = args[2];
		System.out.printf( "K = %d  M = %d  file = %s\n\n", K, M, fName);

		MarkovModel model = new MarkovModel(K, fName);
		String start = "";
		try {
			FileReader R = new FileReader(fName);
			for (int i = 0; i < K; i++) {
				start += (char) R.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Bad File");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
		String text = model.generateText(M, start);
		System.out.println(text);
		System.out.printf( "\n%d characters'\n", text.length());

	}
}
