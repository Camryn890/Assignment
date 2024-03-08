import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A class using an array to manage the data supplied
 */
public class GenericsKbArrayApp
{
   Objects[] array;
    
   /**
    * Constructor of GenericsKbArrayApp to provide the method ArrayFile with input
    * @param files The name of the file that contains the data
    */
   GenericsKbArrayApp(String files){
      ArrayFile(files);
   }
   
   /**
    * Reads the data stored in the file and puts it in an array
    * @param Stringfile the file being read and stored
    * @return The array containing the data of the file 
    */
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

   /**
    * Searches for the item in the array
    * @param term Term being searched for
    * @return The index of the seached item (if not found -1 is returned )
    */   
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
      
   /**
    * Searches for the item in the array
    * @param term the item being searched for 
    * @return returns true if found and false if not 
    */
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
   
   /**
    * Seaches for the item and its sentence in the array
    * @param term the term being searched for
    * @param line the sentence being searched for
    * @return the index of the term in the array or -1 if the item or sentence is not found
    */
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

   /**
    * Adds the item, sentence and score or updates the sentecnce and score (if curent score is lower) if the item is found
    * @param name the term being searched for or added
    * @param Sentence the sentence being updated or added 
    * @param score the score being updated or added
    */
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
   
   /**
    * Displays the sentence of the given tem or diplays term doesn't exist if the term is not in the array
    * @param term the term being searched for
    * @return The sentence of the given statement
    */
   public String displaySentence(String term)
   {
      if(search(term) == true) 
      {
         int i = intSearch(term);
         return "Statement found:" + array[i].getSentence() +  "(Confidence score:" + array[i].getLevel() +")";
      }
      return "Term doesn;t exist";
   }
   
   /**
    *  Displays the score of the given tem and sentence
    * @param term the term being searched for 
    * @param sentence the sentence being seaeched for 
    * @return the confidence level of the term and sentence 
    */
   public String displayScore(String term,String sentence)
   {
      if(search(term) == true){
         int i = DualSearch(term,sentence);
            if(sentence.equals(array[i].getSentence())){
               return "The statement was found and has a confidence score of " + array[i].getLevel();
            }
         return "Sentence given does not match the sentence of the term";
      }
      return "The term does not exist";
   }
} 
 
      
