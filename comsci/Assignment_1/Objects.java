
public class Objects implements Comparable<String>{

   private String term;
   private String sentence;
   private float level;
   
   Objects(String Term, String Sentence, float Level){
      term = Term;
      sentence = Sentence;
      level = Level;
   }

   /**
    * Getter method for retrieving the term of the object
    * @return the term of the object
    */
   public String getTerm()
   {
     return term; 
   }

   /**
    *  Getter method for retrieving the senetence of the object
    * @return the sentence of the object
    */
   public String getSentence()
   {
      return sentence;
   }

   /**
    * Getter method for retrieving the confidence leve of the object
    * @return the score of the object
    */
   public float getLevel()
   {
      return level;
   }

   /**
    * Setter method for setting the term of the object
    * @param term The term being set 
    */
   public void setTerm(String term)
   {
     this.term = term ; 
   }

   /**
    * Setter method for setting the sentence of the object
    * @param sentence The sentence being set 
    */
   public void setSentence(String sentence)
   {
      this.sentence = sentence;
   }   

   /**
    * Setter method for setting the confidence level of the object
    * @param level The score beomg set
    */
   public void setLevel(float level)
   {
      this.level = level;
   }   

   /**
    * Implementing the compareTo method from the Comparable interface
    *@param other The string being compared to 
    *@return An integer representing the result
    */
   public int compareTo(String other)
   {
      return this.getTerm().compareTo(other);
   }
}