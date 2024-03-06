public class BinarySearchNode<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   BinaryTreeNode<Objects> root;

   public void insert ( Objects d )
   {
      if (root == null)
      {
         root = new BinaryTreeNode<Objects> (d, null, null);
      }   
      else
      {
         insert (d, root);
      }   
   }
   public void insert ( Objects d, BinaryTreeNode<Objects> node )
   {
      if (d.compareTo(node.getData()) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<Objects> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
         {
            node.right = new BinaryTreeNode<Objects> (d, null, null);
         }   
         else
         {
            insert (d, node.right);
         }   
      }
   }


   public BinaryTreeNode<Objects> find(Objects d)
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
   
   public BinaryTreeNode<Objects> find( Objects d , BinaryTreeNode<Objects> node)
   {
      if (d.compareTo(node.data) == 0) 
      {
         return node;
      }   
      else if (d.compareTo(node.data) < 0)
      {
         return (node.left == null) ? null : find (d, node.left);
      }   
      else
      {
         return (node.right == null) ? null : find (d, node.right);      
      }
   }



}