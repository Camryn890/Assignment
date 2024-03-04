import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class GenericsKbArrayApp
{
   Objects[] array;
    
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
         Scanner files  = new Scanner(file);
         array = new Objects[100000];
         while(files.hasNextLine())
         {  
            files.useDelimiter("\t");
            String term = files.next();

            String sentence = files.next();
            
            files.useDelimiter("\n");
            float confidence = Float.parseFloat(files.next());

            array[i++]= new Objects(term, sentence, confidence);
            files.nextLine();
         }
         System.out.println("Knowledge base loaded successfully ");
         files.close();
      }
      catch(FileNotFoundException e)
      {
         System.out.println("ERROR");
      }
      return array;
            
      }

   GenericsKbArrayApp(){}

   //searches for item and returns its index
   public int intSearch(String term)
   {
      for(int i = 0; i < array.length; i++)
      {
         if(array[i].getTerm().equals(term))
         {
            return i;
         }   
      }
      return -1;   
   }
   
   //searches for item and returns boolean
   public boolean search(String term){
      for(int i = 0; i < array.length; i++)
      {
         if(array[i].getTerm().equals(term))
         {
            return true;
         }
      } 
      return false;  
   }
   
   //searches for item and string and returns its index in the array 
   public int DualSearch(String term,String line)
   {
      for(int i = 0; i < array.length; i++)
      {
         if(array[i].getTerm().equals(term) && array[i].getSentence().equals(line) )
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
         array[i].setSentence(Sentence);
         if(array[i].getLevel() < score)
         {
            array[i].setLevel(score);
         }  
         System.out.println("Statement for "+ name + " has been updated.");
      }
      else
      {
         array[array.length] = new Objects(name,Sentence,score);
         System.out.println("Statement for "+ name + " has been added.");
      }
   }
   
   //shows that the item was found and returns statement
   public String displaySentence(String term)
   {
      int i = intSearch(term);
      return "Statement found:" + array[i].getSentence() +  "(Confidence score:" + array[i].getLevel() +")";
   }
   
   //shows that the item and statement was found and returns confidence score
   public String displayScore(String term,String sentence)
   {
      int i = DualSearch(term,sentence);
      return "The statement was found and has a confidence score of " + array[i].getLevel();
   }
} 
 
      
