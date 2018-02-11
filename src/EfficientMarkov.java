import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientMarkov extends MarkovModel {

	// Instance variables
	Map<String, ArrayList<String>> myMap; // what from the superclass is preserved in the subclass??

	// Constructor
	public EfficientMarkov(int order) {
		super(order); // calls a constructor from the super class with the same parameter list
		myMap = new HashMap<String, ArrayList<String>>();
	}

	@Override
	// setTraining
	public void setTraining(String text) {
	//public void setTraining(String text) {
		myText = text; // stores the text
		myMap.clear();
		// Generate every possible n-gram and assign them as keys
		for (int i = 0; i <= myText.length() - myOrder; i++) {
			String key = myText.substring(i, i + myOrder);
			if (!myMap.containsKey(key)) {
				myMap.put(key, new ArrayList<String>()); // if the key doesn't exist, add it
				if (i < myText.length() - myOrder) {
					myMap.get(key).add(myText.substring(i + myOrder, i + myOrder + 1)); // add the value of the next
																						// string
				} else {
					myMap.get(key).add(PSEUDO_EOS);
				}
			}
			else if (myMap.containsKey(key)) {
				if (i < myText.length() - myOrder) {
					myMap.get(key).add(myText.substring(i + myOrder, i + myOrder + 1)); // if the key does exist, add
																						// the
																						// value
				} else {
					myMap.get(key).add(PSEUDO_EOS);
				}
			}
		}
	}

	// getFollows
	@Override
	public ArrayList<String> getFollows(String key) {
		// use the map to return the value of the given key
		if (!myMap.containsKey(key)) {
			throw new NoSuchElementException("Key doesn't exist, mate.");

		} else {
			ArrayList<String> valueOfKey = myMap.get(key);
			return valueOfKey;
		}
	}
}
