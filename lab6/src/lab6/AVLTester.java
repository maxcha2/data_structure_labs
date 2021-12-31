package lab6;

public class AVLTester {

	public static void main(String[] args) {
			String [] keys = {"Grape", "Plum", "Orange", 
					"Pear", "Cherry", "Apple", "Strawberry",
					"Kiwi", "Lemon", "Lime"};
					
	        MyTreeMap<String, Integer> map = new MyTreeMap<>();

	        int i = 0;
	        for (String s: keys) {
	            System.out.printf("Adding: %s\n", s);
	            map.put(s,i++);
	            System.out.printf("newheight = %d\n", map.height());
	        }

	        System.out.printf("Size is: %d\n", map.size());
	        

	       for(String s: keys) {
	    	   System.out.printf("Key %s => %d\n", s, map.get(s));
	       }
	       
	       map.treePrinter();
	    }
}
