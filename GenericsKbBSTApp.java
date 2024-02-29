public class GenericsKbBSTApp{

   //how to we "define" the root 
 
      BinaryTreeNode<Objects> root;
      GenericsKbBSTApp()
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
      
   }
