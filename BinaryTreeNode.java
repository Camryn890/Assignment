public class BinaryTreeNode<T>
{
   Objects data;
   BinaryTreeNode<T> left;
   BinaryTreeNode<T> right;
   
   public BinaryTreeNode ( Objects data, BinaryTreeNode<T> left, BinaryTreeNode<T> right )
   {
      this.data = data;
      this.left = left;
      this.right = right;
   }
   
   BinaryTreeNode<T> getLeft () 
   { 
      return left; 
   }
   BinaryTreeNode<T> getRight () 
   { 
      return right; 
   }
}
