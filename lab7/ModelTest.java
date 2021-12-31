package lab7;
public class ModelTest {

    public static void main(String[] args) {
	MarkovModel model = new MarkovModel(2, "SampleTextFiles/markovTest.txt");
	model.printModel();
    }
}
