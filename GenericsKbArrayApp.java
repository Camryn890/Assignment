import java.util.Scanner;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;


public class GenericsKbArrayApp
{
   Objects[] Array;
    
   GenericsKbArrayApp(){
   }
   
   //stores sentences in an array
   public Objects[] ArrayFile(File file)
   {
      int i = 0;
      try
      {
         Scanner files  = new Scanner(new FileInputStream(file));  
         while(files.hasNextLine())
         {  
            files.useDelimiter("//t");
            String term = files.next();
            String sentence = files.next();
            float confidence = files.nextFloat();
            Array[i]= new Objects(term, sentence, confidence);
            i++;
            files.nextLine();
         }
         files.close();
      }
      catch(FileNotFoundException e){}
      return Array;
            
      }
   //searches for item and returns its index
   public int intSearch(String term, File file)
   {
      Objects[] array = ArrayFile(file);
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
   public boolean search(String term, File file){
      Objects[] array = ArrayFile(file);
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
   public int DualSearch(String term,String line, File file)
   {
      Objects[] array = ArrayFile(file);
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
   public void addStatements(String name ,String Sentence, float score, File file)
   {
      if(search(name,file)==true)
      {
         int i = intSearch(name,file);
         Objects[] array = ArrayFile(file);
         array[i].setSentence(Sentence);
         if(array[i].getLevel() < score)
         {
            array[i].setLevel(score);
         }  
   
      }
   }
   
   //shows that the item was found and returns statement
   public String displaySentence(String term,File file)
   {
      Objects[] array = ArrayFile(file);
      int i = intSearch(term,file);
      return "Statement found:" + array[i].getSentence() +  "(Confidence score:" + array[i].getLevel() +")";
   }
   
   //shows that the item and statement was found and returns confidence score
   public String displayScore(String term,String sentence,File file)
   {
      Objects[] array = ArrayFile(file);
      int i = DualSearch(term,sentence,file);
      return "The statement was found and has a confidence score of " + array[i].getLevel();
   }
 
} 
 
      
