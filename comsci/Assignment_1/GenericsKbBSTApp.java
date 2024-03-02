import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class GenericsKbBSTApp<T>{

   //how to we "define" the root 
    private BinarySearchNode<Objects> tree = new BinarySearchNode<>();
      public GenericsKbBSTApp(String file)
      {
        makeTree(file);
      }
      public GenericsKbBSTApp(){}

      private void makeTree(String filename)
      {
         try{
            File file = new File(filename);
            Scanner files  = new Scanner(new FileInputStream(file));
            files.useDelimiter("//t");
            while(files.hasNextLine())
            {
               String terms = files.next();
               String sentences = files.next();
               float confidences = files.nextFloat();
               files.nextLine();
               Objects data = new Objects(terms,sentences,confidences);
               tree.insert(data);

            }
            files.close();
         }

         catch(FileNotFoundException e)
         {
            
         }
      }
      public String Search(String term)
      {
        BinarySearchNode<Objects> data;
        tree.find(term);
      }

   }