package sillySent;

import java.util.Random;

public class SimpleRandomSentences {
	/**

	An array of Strings representing 
	proper nouns/ common nouns/ determiners/ adjectives/ intransitive verbs/ transitive verbs/ conjunctions 
	that can be used in the generation of sentences.
	*/
	private static final String[] PROPER_NOUNS = { "Fred", "Jane", "Richard Nixon", "Miss America" };
	private static final String[] COMMON_NOUNS = { "man", "woman", "fish", "elephant", "unicorn" };
	private static final String[] DETERMINERS = { "a", "the", "every", "some" };
	private static final String[] ADJECTIVES = { "big", "tiny", "pretty", "bald" };
	private static final String[] INTRANSITIVE_VERBS = { "runs", "jumps", "talks", "sleeps" };
	private static final String[] TRANSITIVE_VERBS = { "loves", "hates", "sees", "knows", "looks for", "finds" };
	private static final String[] CONJUNCTIONS = { "and", "or", "but", "because" };
	/**

	An instance of the Random class used to generate random numbers for the sentence generation.
	@see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Random.html">Random</a>
	*/
	private static Random random = new Random();
	/**

	Generates a simple sentence consisting of a noun phrase followed by a verb phrase.
	@return a String representing a simple sentence.
	*/
	private static String simpleSentence() {
		String sent = nounPrase() + verbPhrase();
		return sent;
	}
	/**

	Generates a sentence consisting of one or more simple sentences joined together with a conjunction.
	The method uses recursion to create complex sentences up to a maximum depth of 4.
	@param recDebth an integer representing the current depth of recursion.
	@return a String representing a sentence.
	*/
	private static String sentence(int recDebth) {
	String s = simpleSentence();
	
		while (recDebth <= 4) {
			if (random.nextDouble() < 0.5) {
				s = simpleSentence() + random(CONJUNCTIONS) + " " + sentence(recDebth += 1);
				
			}
		}
	return s;
	}
	/**
	Generates a random noun phrase by selecting one of four code blocks based on the value
	of a randomly generated integer. The behavior of the code will depend on the implementation
	of each block of code.
	@return a String representing a noun phrase, consisting of a determiner, adjective(s),
	and/or a common or proper noun, with optional verb phrase.
	@see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Random.html">Random</a>
	*/
	private static String nounPrase() {
		String nP;
		//random.nextInt(4) - method call that generates a random integer between 0 (inclusive) and 4 (exclusive).
		switch (random.nextInt(4)) {
		case 0:
			nP = random(DETERMINERS) + " " + random(COMMON_NOUNS) + " ";
			break;
		case 1:
			nP = random(DETERMINERS) + " " + random(ADJECTIVES) + " " + random(COMMON_NOUNS) + " ";
			break;
		case 2:
			nP = random(DETERMINERS) + " " + random(ADJECTIVES) + " " + random(COMMON_NOUNS) + " who " + verbPhrase();
			break;
		case 3:
			nP = random(PROPER_NOUNS) + " ";
			break;
		default:
			nP = random(PROPER_NOUNS) + " ";
			break;
		}
		return nP;
	}
	/**
	
	Generates a random verb phrase by selecting one of four code blocks based on the value
	of a randomly generated integer. The behavior of the code will depend on the implementation
	of each block of code.
	@return a String representing a verb phrase, consisting of an intransitive verb,
	transitive verb with noun phrase, "is" followed by an adjective, or a belief statement
	with a simple sentence.
	@see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Random.html">Random</a>
	
	*/
	private static String verbPhrase() {
		String vP;
		//random.nextInt(4) - method call that generates a random integer between 0 (inclusive) and 4 (exclusive).
		switch (random.nextInt(4)) {
		case 0:
			vP = random(INTRANSITIVE_VERBS) + " ";
			break;
		case 1:
			vP = random(TRANSITIVE_VERBS) + " " + nounPrase() + " ";
			break;
		case 2:
			vP = "is " + random(ADJECTIVES) + " ";
			break;
		case 3:
			vP = "believes that " + simpleSentence() + " ";
			break;
		default:
			vP = random(INTRANSITIVE_VERBS) + " ";
			break;
		}
		return vP;
	}
	/**

	Returns a random String from a given list of Strings.
	@param list an array of Strings to choose from.
	@return a random String from the given list.
	@see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Random.html">Random</a>
	*/
	private static String random(String[] list) {
		return list[random.nextInt(list.length)];
	}
	/**

	The main method that is executed when the program is run. It calls the sentence method
	with a parameter of 0 and prints the resulting String to the console.
	@param args an array of Strings that may be passed as arguments to the program.
	*/
	public static void main(String[] args) { 
		/**
		A loop that iterates five times and calls the "sentence" method with a parameter (a recursion depth) of 0,
		prints a generated sentence to the console using the sentence method with a recursion depth of 0.
		which prints a sentence to the console.
		@param None.
		@return None.
		*/
		for (int i=0; i<5; i++) {
		System.out.println(sentence(0));}
	}

}

/*
The code is a Java program that generates random sentences using various arrays of words. It consists of a class called SimpleRandomSentences 
with private static methods that generate different parts of a sentence such as noun phrases, verb phrases, simple sentences, and complete sentences.

The class has several private static arrays of Strings containing various types of words including 
proper nouns, common nouns, determiners, adjectives, intransitive verbs, transitive verbs, and conjunctions. 
These arrays are used to randomly select words to create sentences.

The methods in the class use the Random class to generate random numbers for selecting words from the arrays. 
The simpleSentence() method generates a simple sentence consisting of a noun phrase followed by a verb phrase. 
The sentence() method generates a sentence consisting of one or more simple sentences joined together with a conjunction. 
This method uses recursion to create complex sentences up to a maximum depth of 4.

The nounPhrase() method generates a random noun phrase by selecting one of four code blocks based on the value of a randomly generated integer. 
The verbPhrase() method generates a random verb phrase using a similar approach.

Finally, there is a utility method called random() that returns a random String from a given list of Strings.
*/