/**
 * Author: Hussein Suleman (code could have been altered)
 * Represents a node in the binary tree
 * <datatype> is the type of data stored
 */
public class BinaryTreeNode<datatype> 
{
   Objects data;
   BinaryTreeNode<datatype> left;
   BinaryTreeNode<datatype> right;
   
   /**
    * Class constructor of the BinaryTreeNode with the data that is and child nodes
    * @param data contains the term, sentence and confidence level (data stored in node)
    * @param left left child of current node
    * @param right right child of current node
    */
   public BinaryTreeNode ( Objects data, BinaryTreeNode<datatype> left, BinaryTreeNode<datatype> right )
   {
      this.data = data;
      this.left = left;
      this.right = right;
   }

   /**
    * Returns the left child of current node
    * @return the left child of the node
    */
   
   public BinaryTreeNode<datatype> getLeft() 
   { 
      return left; 
   }

   /**
    *  Returns the right child of current node
    * @return the right child of the node
    */
   public BinaryTreeNode<datatype> getRight() 
   { 
      return right; 
   }

   /**
    * returns the data sstored in the node
    * @return the data sstored in the node
    */
   public Objects getData()
   {
      return data;
   }  

   /**
    * Sets the left child node 
    * @param left left child of current node
    */
   public void setLeft(BinaryTreeNode<datatype> left)
   {
      this.left = left;
   }  

   /**
    * Sets the right child node 
    * @param right right child of current node
    */
   public void setRight(BinaryTreeNode<datatype> right)
   {
      this.right = right;
   }

}
