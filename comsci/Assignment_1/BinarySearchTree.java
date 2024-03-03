public class BinarySearchTree<datatype extends Comparable<datatype>>
{
   BinaryTreeNode<datatype> root;

   BinarySearchTree()
   {
    root = null;
   }
   public void insert ( Objects d )
   {
      if (root == null)
      {
         root = new BinaryTreeNode<datatype> (d, null, null);
      }   
      else
      {
         insert (d, root);
      }   
   }
   public void insert ( Objects d, BinaryTreeNode<datatype> node )
   {
      if (d.getTerm().compareTo(node.getData().getTerm()) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<datatype> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
         {
            node.right = new BinaryTreeNode<datatype> (d, null, null);
         }   
         else
         {
            insert (d, node.right);
         }   
      }
   }


   public BinaryTreeNode<datatype> find(Objects d)
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
   
   public BinaryTreeNode<datatype> find( Objects d , BinaryTreeNode<datatype> node)
   {
      if (d.getTerm().compareTo(node.getData().getTerm()) == 0) 
      {
         return node;
      }    
      else if (d.getTerm().compareTo(node.getData().getTerm()) < 0)
      {
         return (node.left == null) ? null : find (d, node.left);
      }   
      else
      {
         return (node.right == null) ? null : find (d, node.right);      
      }
   }
   public BinaryTreeNode<datatype> find1(Objects d)
   {
      if(root==null)
      {
         return null;
      }
      else
      {
         return find1(d,root);
      } 
   }
   
   public BinaryTreeNode<datatype> find1( Objects d , BinaryTreeNode<datatype> node)
   {
      if (d.getTerm().compareTo(node.getData().getTerm()) == 0 && d.getSentence().compareTo(node.getData().getSentence()) == 0 ) 
      {
         return node;
      }    
      else if (d.getTerm().compareTo(node.getData().getTerm()) < 0)
      {
         return (node.left == null) ? null : find1 (d, node.left);
      }   
      else
      {
         return (node.right == null) ? null : find1 (d, node.right);      
      }
   }
}
