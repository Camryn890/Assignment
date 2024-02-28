public class GenericsKbBSTApp implements Comparable<GenericsKbBSTApp>{

   //how to we "define" the root 
   BinarySearchNode<Objects> root;
   
   GenericsKbBSTApp()
   { 
   }
   
   public BinarySearchNode<Objects> find(Objects d)
   {
      if(root==null)
      {
         return null;
      }
      else
      {
         return find(d,root);
      } 
   }
   
   public BinarySearchNode<Objects> find( Objects d , BinarySearchNode<Objects> node)
   {
      int comp = d.compareTo(node);
      if(comp == 0)
      {
         return node;
      }
      else if(comp < 0)
      {
         return find(d,node.getLeft());
         //return(node.left == null);
      }
      else if(comp>0)
      {
         return find(d,node.getRight());
         //return(node.right == null);
      }
   }



   public void insert(Objects d)
   {
      if(root == null)
      {
         root = new BinarySearchNode<Objects> (d,null,null);
      }
      else
      {
         insert(d, root);
      }
      
   }
   
   public void insert(Objects d, BinarySearchNode<Objects> node){
      if(d.compareTo(node)<=0)
      {
         if(node.getLeft() == null)
         {
            node.setLeft(new  BinarySearchNode<Objects>(d,null,null));
         }
         else
         {
            insert(d,node.getLeft());
         }
      }
      else
      {
         if(node.getRight() == null)
         {
            node.setRight(new  BinarySearchNode<Objects>(d,null,null));

         }
         else
         {
            insert(d,node.getRight());
         }
       
      }
   
   }
}   