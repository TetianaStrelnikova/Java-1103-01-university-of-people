package sillySent;

import java.util.Random;

public class SimpleRandomSentences {

	private static final String[] PROPER_NOUNS = { "Fred", "Jane", "Richard Nixon", "Miss America" };
	private static final String[] COMMON_NOUNS = { "man", "woman", "fish", "elephant", "unicorn" };
	private static final String[] DETERMINERS = { "a", "the", "every", "some" };
	private static final String[] ADJECTIVES = { "big", "tiny", "pretty", "bald" };
	private static final String[] INTRANSITIVE_VERBS = { "runs", "jumps", "talks", "sleeps" };
	private static final String[] TRANSITIVE_VERBS = { "loves", "hates", "sees", "knows", "looks for", "finds" };
	private static final String[] CONJUNCTIONS = { "and", "or", "but", "because" };

	private static Random random = new Random();

	private static String simpleSentence() {
		String sent = nounPrase() + verbPhrase();
		return sent;
	}
	private static String sentence() {
		String s = simpleSentence();
		if (random.nextDouble() < 0.5)
		{s = simpleSentence()+ random(CONJUNCTIONS)+ sentence();}
		return s;
	}

	private static String nounPrase() {
		/*
		 * <noun_phrase> ::= <proper_noun> | <determiner> [ <adjective> ]. <common_noun>
		 * [ who <verb_phrase> ]
		 */
		String nP;
		
		switch(random.nextInt(4)) {
        case 0:
            nP = random(PROPER_NOUNS) + ". " + random(COMMON_NOUNS) + "who" + verbPhrase();
        case 1:
        	nP = random(DETERMINERS) + " " + random(ADJECTIVES) + ". " + random(COMMON_NOUNS) + "who" + verbPhrase();
        case 2:
        	nP = random(DETERMINERS) + " " + random(ADJECTIVES)+ ". ";
        case 4:
        	nP = random(PROPER_NOUNS)+ ". ";
        default:
        	nP = "Something is wrong with the switch!!";
    }
		
		return nP;
	}

	private static String verbPhrase() {
		/*
		 * <verb_phrase> ::= <intransitive_verb> | <transitive_verb> <noun_phrase> | is
		 * <adjective> | believes that <simple_sentence>
		 */
		String vP = random(INTRANSITIVE_VERBS) + random(TRANSITIVE_VERBS) + nounPrase() + "is" + random(ADJECTIVES)
				+ "believes that" + simpleSentence();
		return vP;
	}

	private static String random(String[] list) {
		return list[random.nextInt(list.length)];
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(generateSentence());
		}
	}

}