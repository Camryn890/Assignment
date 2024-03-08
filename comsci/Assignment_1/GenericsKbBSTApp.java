import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Author: Hussein Suleman (code could have been altered)
 * A class using a binary search tree to manage the data supplied
 */
public class GenericsKbBSTApp{

    private BinarySearchTree<Objects> tree = new BinarySearchTree<>();

/**
 * Constructor of the GenericsKbApp class
 * @param file File that contains the data
 */    
      public GenericsKbBSTApp(String file)
      {
         makeTree(file);
      }

      /**
       * Reads the data of the file and makes a binary search tree
       * @param filename The name of the file containing data
       */
      private void makeTree(String filename)
      {

         try{
            File file = new File(filename);
            Scanner files  = new Scanner(file);
            while(files.hasNextLine())
            {
               files.useDelimiter("\t");
               String terms = files.next();

               String sentences = files.next();

               files.useDelimiter("\n");
               float confidences = Float.parseFloat(files.next());

               Objects data = new Objects(terms,sentences,confidences);
               tree.insert(data);
               files.nextLine();
            }
            System.out.println("Knowledge base loaded successfully ");
            files.close();
         }

         catch(FileNotFoundException e)
         {
            System.out.println("Please try again");
         }
      }

      /**
       * Displays the sentence that is stored in the same node as the term that is given or displays not found if teh term doesn't exist
       * @param term the term that is searched for
       */

      public void displaySentence(String term)
      {
        Objects group = new Objects(term,null,0);
        BinaryTreeNode<Objects> result = tree.find(group);
        if(result != null)
        {
         System.out.println("Statement found:" + result.getData().getSentence() +  "(Confidence score:" + result.getData().getLevel() +")");
        }
        else
        {
         System.out.println("No statement found for the term " + term);
        }
      }

      /**
       * displays the confidence score of the term and sentence given or displays no statements if the term and sentence is not found 
       * @param term the term that is searched for 
       * @param sentence the sentence that is searched for
       */
      public void displayScore(String term,String sentence)
      {
         Objects group = new Objects(term,sentence,0);
         BinaryTreeNode<Objects> result = tree.find1(group);
         if(result != null)
        {
         System.out.println("The statement was found and has a confidence score of " + result.getData().getLevel());
        }
        else
        {
         System.out.println("No statement found");
        }
      }

      /**
       * Adds the term, sentence and score if the term is not found 
       * Updates the sentence and confidence level (if the score is higher than current) if term is found 
       * @param term The term being added or searched for
       * @param sen The sentence being added or uopdated
       * @param score The score being added or updated
       */
      public void addStatements(String term, String sen, float score)
      {
         Objects group = new Objects(term,sen,score);
         BinaryTreeNode<Objects> result = tree.find(group);
         if(result != null)
         {
            if (result.getData().getLevel()<score)
            {
               group = new Objects(term,sen,result.getData().getLevel());
            }
            tree.insert(group);
            System.out.println("Statement for "+ term + " has been updated.");
        }
        else
        {
         tree.insert(group);
         System.out.println("Statement for "+ term + " has been added.");

         }
      }   
   }