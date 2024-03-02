public class BinaryTreeNode<datatype> 
{
   Objects data;
   BinaryTreeNode<datatype> left;
   BinaryTreeNode<datatype> right;
   
   public BinaryTreeNode ( Objects data, BinaryTreeNode<datatype> left, BinaryTreeNode<datatype> right )
   {
      this.data = data;
      this.left = left;
      this.right = right;
   }
   
   public BinaryTreeNode<datatype> getLeft() 
   { 
      return left; 
   }
   public BinaryTreeNode<datatype> getRight() 
   { 
      return right; 
   }
   public Objects getData()
   {
      return data;
   }  
   public void setLeft(BinaryTreeNode<datatype> left)
   {
      this.left = left;
   }  
   public void setRight(BinaryTreeNode<datatype> right)
   {
      this.right = right;
   }

}
