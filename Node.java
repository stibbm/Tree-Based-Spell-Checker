package Trie_TypeDictionary;

public class Node {


	// counts the number of words that are in the dictionary
	int wordCount=0;
	Node[] children = new Node[26];
	boolean endOfWord;

	/**
	 * Convert from character value to a value between 0 and 25 based on location in
	 * alphabet if the input char is alphabetical and if the character is not
	 * alphabetical it returns a -1. Turns both lowercase and uppercase to the same
	 * 0-26 identifier so dont have to worry about being uppercase or lowercase but
	 * does not support non-letter characters.
	 * 
	 * @param ch
	 * @return
	 */
	public int convertCharToInt(char ch) {
		if (ch >= 65 && ch <= 90) {
			return ((int) ch - 65);
		} else if (ch >= 97 && ch <= 122) {
			return ((int) ch - 97);
		}
		return -1;
	}

	/**
	 * Convert from int to the corresponding letter character
	 * 
	 * @param val
	 * @return
	 */
	public char convertIntToChar(int val) {
		if (val >= 0 && val < 26) {
			return ((char) (val + 97));
		}
		return (char) 0;
	}
	
	/**
	 * Creates a new node updates nodes below it to contain the rest of the string passed to it
	 * @param word
	 */
	public Node(String word) {
		addWord(word);
	}

	/**
	 * Create a new Head Node Object
	 * 
	 * @param word
	 */
	public Node() {
	}

	/**
	 * Add a word to the dictionary
	 * 
	 * @param word
	 */
	public void addWord(String word) {
		wordCount++;
		//char ch = word.charAt(0);
		//System.out.println(ch);
		if (word.length() > 0 && children[convertCharToInt(word.charAt(0))]==null) {
			children[convertCharToInt(word.charAt(0))] = new Node(word.substring(1));
		}
		else if(word.length()>0 && children[convertCharToInt(word.charAt(0))]!=null) {
			children[convertCharToInt(word.charAt(0))].addWord(word.substring(1));
		}
		else if (word.length() == 0) {
			endOfWord = true;
		}
	}

	/**
	 * Checks if the word exists in the dictionary
	 * @param word
	 * @return
	 */
	public boolean containsWord(String word) {
		//System.out.println(word);
		for(int i=0;i<26;i++) {
			if(children[i]!=null) {
				//System.out.println(convertIntToChar(i));
			}
		}
		if (word.length() > 0 && children[convertCharToInt(word.charAt(0))] != null) {
			return children[convertCharToInt(word.charAt(0))].containsWord(word.substring(1));
		} else if (word.length() == 0 && endOfWord) {
			return true;
		}
		return false;
	}

	/**
	 * Solely for testing purposes
	 * 
	 * @param ch
	 */
	public Node(char ch) {
		System.out.println(ch);
		System.out.println(convertCharToInt(ch));
		System.out.println(convertIntToChar(convertCharToInt(ch)));

	}

}
