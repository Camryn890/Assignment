import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class GenericsKbBSTApp{

    private BinarySearchTree<Objects> tree = new BinarySearchTree<>();

      public GenericsKbBSTApp(String file)
      {
         makeTree(file);
      }
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