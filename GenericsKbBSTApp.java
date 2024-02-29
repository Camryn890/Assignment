import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class GenericsKbBSTApp<T>{

   //how to we "define" the root 
 
      BinaryTreeNode<Objects> root;
      public GenericsKbBSTApp()
      {
         root = null;
      }
         
      public int getHeight ()
      {
         return getHeight (root);
      }   

      public int getHeight ( BinaryTreeNode<Objects> node )
      {
         if (node == null)
         {
            return -1;
         }   
         else
         {
            return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
         }   
      }

      public int getSize ()
      {
         return getSize (root);
      }   

      public int getSize ( BinaryTreeNode<Objects> node )
      {
         if (node == null)
         {
            return 0;
         }   
         else
         {
            return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
         }   
      }
      
      public void visit ( BinaryTreeNode<Objects> node )
      {
         System.out.println (node.getData());
      }

      public BinarySearchNode<T>  MakeTree(){String fileSt}
      {
         try{
            File file = new File(fileSt);
            Scanner files  = new Scanner(new FileInputStream(file));
            files.useDelimiter("//t");
            String term = files.next();
            String sentence = files.next();
            float confidence = files.nextFloat();
            Objects Node = new Objects(term,sentence,confidence);
            BinarySearchNode<Objects> Tree = new BinarySearchNode<Objects>();
            Tree.insert(Node);
            while(files.hasNextLine())
            {
               files.hasNextLine();
               String terms = files.next();
               String sentences = files.next();
               float confidences = files.nextFloat();
               Objects Nodes = new Objects(term,sentence,confidence);
               Tree.insert(Node,Tree);


            }
            files.close();
            return Tree;
         }

         catch(FileNotFoundException e)
         {
            
         }

      }

   }