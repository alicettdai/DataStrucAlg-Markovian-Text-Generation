import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

public class EfficientWordMarkov extends WordMarkovModel {


	// Instance variables
	private Map<WordGram, ArrayList<String>> myMap;

	// Constructor
	public EfficientWordMarkov(int order) {
		super(order); // calls a constructor from the super class with the same parameter list
		myMap = new TreeMap<WordGram, ArrayList<String>>(); //Change to a tree map to test runtime
	}

	// setTraining goes through the training text and then
	@Override
	public void setTraining(String text) {
		myWords = text.split("\\s+"); // splits the string into an String array
		myMap.clear();
		// Generate every possible n-gram and assign them as keys
		for (int i = 0; i <= myWords.length - myOrder; i++) {
			WordGram key = new WordGram(myWords, i, myOrder);
			if (!myMap.containsKey(key)) {
				myMap.put(key, new ArrayList<String>()); // if the key doesn't exist, add it
				if (i < myWords.length - myOrder) {
					myMap.get(key).add(myWords[i + myOrder]); // add the value of the next
																// string
				} else {
					myMap.get(key).add(PSEUDO_EOS);
				}
			} else if (myMap.containsKey(key)) {
				if (i < myWords.length - myOrder) {
					myMap.get(key).add(myWords[i + myOrder]); // if the key does exist, add
																// the
																// value
				} else {
					myMap.get(key).add(PSEUDO_EOS);
				}
			}
		}

	}

	// getFollows retrieves the arrayList of words that could follow the wordGram
	@Override
	public ArrayList<String> getFollows(WordGram key) {
		// use the map to return the value of the given key
		if (!myMap.containsKey(key)) {
			throw new NoSuchElementException("WordGram doesn't exist, mate.");

		} else {
			ArrayList<String> valueOfKey = myMap.get(key);
			return valueOfKey;
		}
	}
}
