public class BinaryTreeObject{

   private String term;
   private String sentence;
   private float score;

   BinaryTreeObject(){}
   
   BinaryTreeObject(String term,String sentence,float score){
      this.term = term;
      this.sentence = sentence;
      this.score = score;
   }
   
   public String getTerm()
   {
      return term;
   }
   
   public String getSenteces()
   {
      return sentence;
   }
   public float getLevel()
   {
      return score;
   }

}