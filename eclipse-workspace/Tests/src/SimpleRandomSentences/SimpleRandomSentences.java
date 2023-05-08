package SimpleRandomSentences;

/**
 * @author Jonathan Templer
 */
public class SimpleRandomSentences {

   static final String[] conjunctions = {"and", "or", "but", "because"};

   static final String[] proper_noun = {"Fred", "Jane", "Richard Nixon", "Miss America"};

   static final String[] common_noun = {"man", "woman", "fish", "elephant", "unicorn"};

   static final String[] determiner = {"a", "the", "every", "some"};

   static final String[] adjective = {"big", "tiny", "pretty", "bald"};

   static final String[] intransitive_verb = {"runs", "jumps", "talks", "sleeps"};

   static final String[] transitive_verb = {"loves", "hates", "sees", "knows", "looks for", "finds"};

   
   public static void main(String[] args) {
     sentence();
     System.out.println(".\n\n");
   }
   
   /*
    * <sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]
    */
   static void sentence() {
	  simpleSentence();
      if (Math.random() > 0.5) {
         System.out.print(randomItem(conjunctions));
         sentence();
      }
   }
   
   /*
    * <simple_sentence> ::= <noun_phrase> <verb_phrase>
    */
   static void simpleSentence() {
      nounPhrase();
      verbPhrase();
   }
   
	/*
	 * <noun_phrase> ::= <proper_noun> | <determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]
	 */
   static void nounPhrase() {
	   if (Math.random() < 0.5) {
          System.out.print(randomItem(proper_noun));
	   }
	   else {
		   System.out.print(randomItem(determiner));
		   if (Math.random() > 0.75) {
	             System.out.print(randomItem(adjective));
		   }
		   System.out.print(randomItem(common_noun));
		   if (Math.random() > 0.75)
			   verbPhrase();
	   }
   }
   
   /*
    * <verb_phrase> ::= <intransitive_verb> |
		<transitive_verb> <noun_phrase> |
		is <adjective> |
		believes that <simple_sentence>
    */
   static void verbPhrase() {
	   int r = (int)(Math.random()*4);
	   switch(r) {
		   case 1:
			   System.out.print(randomItem(intransitive_verb));
			   break;
		   case 2:
			   System.out.print(randomItem(transitive_verb));
			   nounPhrase();
			   break;
		   case 3:
			   System.out.print("is ");
			   System.out.print(randomItem(adjective));
			   break;
		   default:
			   System.out.print("believes that ");
			   simpleSentence();
			   break;
	   }
   }
   
   private static String randomItem(String[] array) {
	   return array[(int)(Math.random()*array.length)] + " ";
   }
   
}