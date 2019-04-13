package Trie_TypeDictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
	
	public static void main(String[] args) throws IOException {
		Node dictionary = newDictionary("10000Words.txt");
		
		System.out.println(dictionary.wordCount);
		
		boolean b1 = dictionary.containsWord("word");
		boolean b2 = dictionary.containsWord("which");
		
		String s1 = "Will the dictionary recognize all of the words in this simple sentence";
		String[] s1_tokens = s1.split(" ");
		
		for(int i=0;i<s1_tokens.length;i++) {
			System.out.println(s1_tokens[i]);
			System.out.println(dictionary.containsWord(s1_tokens[i]));
			
		}
		
	}
	
	/**
	 * Create a new Dictionary that will use the file with filename equal to
	 * the string passed as the list of words that should be included within the 
	 * dictionary.
	 * @param dictionaryFile
	 * @return
	 * @throws IOException
	 */
	public static Node newDictionary(String dictionaryFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(dictionaryFile)));
		String line = null;
		Node node = new Node();
		while((line = br.readLine())!=null) {
			node.addWord(line);
		}
		return node;
	}
	
	
	

}
