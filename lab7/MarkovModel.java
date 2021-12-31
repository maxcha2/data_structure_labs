package lab7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MarkovModel {
	int K;
	HashMap<String, State> model;

	public MarkovModel(int K, String fName) {
		this.K = K;
		model = new HashMap<String, State>();
		train(fName);
	}

	public void train(String fName) {
		try {
			FileReader F = new FileReader(fName);
			// Step 1: Use FileReader F to build up a string s
			// with the first K letters of the file.
			//
			// Step 2: Go into a loop until F.read( ) returns -1
			// Let c be (char)F.read().  c is a follow-up character to s
			//
			// if model.containsKey(s) then get the state the model
			// pairs with s.  Call the state's add(c) method.
			// 
			// If model doesn't contain s as a key then make a new state
			// for s, call the new state's add(c) method, and put the
			// new state into the model
			//
			// Update s by adding  c to its end (s += c) and dropping
			// the first character of s (s=s.substring(1).                                  {
			String s = "";
			for (int i = 0; i < K; i++) {
				s += ((char)F.read());
			}
			boolean done = false;
			while (!done) {
				int  c = F.read();
			    if (c == -1) {
			    	done = true;
			    }
			    else {
			    	if (model.containsKey(s)) {
				    	State x = model.get(s);
				    	x.add((char)c);
				    	
				    }
				    if (!model.containsKey(s)) {
				    	State y = new State(s);
				    	y.add((char)c);
				    	model.put(s, y);
				    }
				    
			    	s += (char)  c; 
			    	s = s.substring(1);
				    
			    }
			}
		} catch (FileNotFoundException e) {
			System.out.println("Bad File");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
	}

	public void printModel() {
		System.out.printf("%d distinct states:\n", model.size());
		for (String s : model.keySet())
			System.out.printf("   %s\n", model.get(s));
	}

	public String generateText(int M, String start) {
		String s = start;
		String text = start;
		while (text.length() < M) {
			// if s is a key for the model get the
			// state associated with s
			// Use's the state's generate( ) method to get a
			// follow-up character c.
			// Add c to the end of s and to the end of text
			// and delete the first character of s.
			// If s is not a key for the model use
			// reset s to start
		   // when text has length M just return text and you are done
			if (model.containsKey(s)) {
				model.get(s);
				State c = new State(s);
				c.generate();
				s = s + c;
				text = text + c;
				s = s.substring(1);
			}
			else if (!model.containsKey(s)) {
				start = s;
			}
		}
		return text;
	}

}
