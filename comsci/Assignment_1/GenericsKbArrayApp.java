import java.util.Scanner;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;


public class GenericsKbArrayApp
{
   Objects[] Array;
    
   GenericsKbArrayApp(String files){
      ArrayFile(files);
   }
   
   //stores sentences in an array
   public Objects[] ArrayFile(String Stringfile)
   {
      int i = 0;
      try
      {
         File file = new File(Stringfile);
         Scanner files  = new Scanner(new FileInputStream(file));  
         Array = new Objects[1000000];
         files.useDelimiter("//t");
         while(files.hasNextLine())
         {  
            String term = files.next();
            String sentence = files.next();
            float confidence = files.nextFloat();
            files.nextLine();
            Array[i++]= new Objects(term, sentence, confidence);
         }
         System.out.println("Knowledge base loaded successfully ");
         files.close();
      }
      catch(FileNotFoundException e)
      {
         System.out.println("ERROR");
      }
      return Array;
            
      }

   GenericsKbArrayApp(){}

   //searches for item and returns its index
   public int intSearch(String term)
   {
      for(int i = 0; i < Array.length; i++)
      {
         if(Array[i].getTerm().equals(term))
         {
            return i;
         }   
      }
      return -1;   
   }
   
   //searches for item and returns boolean
   public boolean search(String term){
      for(int i = 0; i < Array.length; i++)
      {
         if(Array[i].getTerm().equals(term))
         {
            return true;
         }
      } 
      return false;  
   }
   
   //searches for item and string and returns its index in the array 
   public int DualSearch(String term,String line)
   {
      for(int i = 0; i < Array.length; i++)
      {
         if(Array[i].getTerm().equals(term) && Array[i].getSentence().equals(line) )
         {
            return i;
         }
      } 
      return -1;  
   }   


   //user inputs statement and it updates the statement
   public void addStatements(String name ,String Sentence, float score)
   {
      if(search(name)==true)
      {
         int i = intSearch(name);
         Array[i].setSentence(Sentence);
         if(Array[i].getLevel() < score)
         {
            Array[i].setLevel(score);
         }  
         System.out.println("Statement for "+ name + " has been updated.");
      }
   }
   
   //shows that the item was found and returns statement
   public String displaySentence(String term)
   {
      int i = intSearch(term);
      return "Statement found:" + Array[i].getSentence() +  "(Confidence score:" + Array[i].getLevel() +")";
   }
   
   //shows that the item and statement was found and returns confidence score
   public String displayScore(String term,String sentence)
   {
      int i = DualSearch(term,sentence);
      return "The statement was found and has a confidence score of " + Array[i].getLevel();
   }



} 
 
      
