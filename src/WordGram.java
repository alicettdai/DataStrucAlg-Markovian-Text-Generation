import java.util.Arrays;

public class WordGram implements Comparable<WordGram> {

	private int myHash;
	private String[] myWords;

	public WordGram(String[] words, int index, int size) {
		// makes a string array of "size" words
		// index is the place you start
		myWords = new String[size];
		int j = 0;
		for (int i = index; i < index + size; i++) {
			myWords[j] = words[i];
			j++;
		}
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int hash = 1;
		for (String s : myWords) {
			hash = hash * prime + s.hashCode();
		}
		myHash = hash;
		return myHash;
	}

	@Override
	public String toString() {
		String myWordsString=new String();
		myWordsString = String.join(" ", myWords);
		return myWordsString;
		
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof WordGram)) { //detects if it's a wordGram or not
			return false;
		} 
		else { //it definitely is a wordGram
			WordGram wg = (WordGram) other;
			if (Arrays.equals(this.myWords,wg.myWords)) {// this.myWords.equals(wg.myWords) literally asks if they're the same exact thing. NOT USEFUL
				return true;
			} else {
				return false;
			}
		}
		
	}

	@Override
	public int compareTo(WordGram other) {
		int compare=0; // initializer
		if (equals(other)) { // calls the equal method, a boolean
			return 0;
		}
		if (this.myWords.length == other.myWords.length) { // when the word grams are the same length
			for (int k = 0; k < this.myWords.length; k++) {
				// compare this.myWords[k] to other.myWords[k]
				compare = this.myWords[k].compareTo(other.myWords[k]); // compareTo here is part of the STRING
																		// METHOD, it's already defined.
				if (compare != 0) {
					return compare;
				}
			}
		}

		else {
			int min = Math.min(this.myWords.length, other.myWords.length); // when the word grams are different lengths
			for (int k = 0; k < min; k++) {
				compare = this.myWords[k].compareTo(other.myWords[k]);
				if (compare != 0) {
					return compare; // it'll break out of the loop
				}
			}
			if (this.myWords.length < other.myWords.length) {
				return -1;
			} else {
				return 1;
			}
		}
		return compare; //some random number, shouldn't ever need to come here
	}

	public int length() {
		int size = myWords.length;
		return size;
	}

	public WordGram shiftAdd(String last) {
		String[] shiftedWords = new String[myWords.length];
			for(int i=0; i<myWords.length; i++) {
				if(i<myWords.length-1) {
					shiftedWords[i]=myWords[i+1];
				}
				else if  (i==myWords.length-1) {
					shiftedWords[i]=last;
				}
			}
		//turn the String[] to a Word Gram
		WordGram shiftedWordGram= new WordGram(shiftedWords,0,myWords.length);
		return shiftedWordGram;
	}
}
