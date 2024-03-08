/**
 * Author: Hussein Suleman (code could have been altered)
 * Repressnets a binary search tree that stores objects 
 * The objects datatype must implement the Comparable inteface 
 * <datatype> is the type ofdata stored
 */
public class BinarySearchTree<datatype extends Comparable<String>>
{
   BinaryTreeNode<datatype> root;

   /**
    * Contructor that constucts binary search tree that is empty
    */
   BinarySearchTree()
   {
    root = null;
   }

   /**
    * inserts new object into binary search tree
    * @param d The object that is inserted
    */
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

   /**
    * inserts a new object into the subtree that has the node as its root
    * @param d the object that ius inserted
    * @param node the root of the subtree
    */

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

   /**
    * Finds the object in th ebinry search tree
    * @param d the object that is searched for
    * @return the node containg the data (if node not found it returns null)
    */
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
   
   /**
    * find the object in the subtree that has the node as its root
    * @param d the object that is searched for 
    * @param node the root of the subtree
    * @return the node that has the data stored (if not it returns null)
    * compares the term of the object d and the term of the node being searched
    */
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

    /**
    * Finds the object in th ebinry search tree
    * @param d the object that is searched for
    * @return the node containg the data (if node not found it returns null)
    */
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
   
   /**
    * find the object in the subtree that has the node as its root
    * @param d the object that is searched for 
    * @param node the root of the subtree
    * @return the node that has the data stored (if not it returns null) 
    * compares the term and sentence of the object d and the term and sentence of the node being searched
    */
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
