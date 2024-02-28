
public class Objects{

   private String term;
   private String sentence;
   private float level;
   
   Objects(){
   }
   Objects(String Term, String Sentence, float Level){
      term = Term;
      sentence = Sentence;
      level = Level;
   }
   public String getTerm()
   {
     return term; 
   }
   public String getSentence()
   {
      return sentence;
   }
   public float getLevel()
   {
      return level;
   }
   public void setTerm(String term)
   {
     this.term = term ; 
   }
   public void setSentence(String sentence)
   {
      this.sentence = sentence;
   }   
   public void setLevel(float level)
   {
      this.level = level;
   }   


   


}