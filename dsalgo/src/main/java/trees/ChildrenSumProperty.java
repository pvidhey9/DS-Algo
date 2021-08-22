package trees;

import static trees.BinaryTree.insertNode;
import static trees.BinaryTree.printTreeInorder;

/* Condition for tree : For every node, data value must be equal to the sum of values in left and right child */
public class ChildrenSumProperty {

  static boolean isChildrenSumPropertySatisfied(Node root){

    if(root == null){
      return true;
    }

    if(root.left == null && root.right == null){
      return true;
    }

    int data = root.key;
    int leftData = root.left != null ? root.left.key : 0;
    int rightData = root.right != null ? root.right.key : 0;

    return (data == leftData + rightData) && isChildrenSumPropertySatisfied(root.left) && isChildrenSumPropertySatisfied(root.right);
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(10);
    insertNode(binaryTree, 8);
    insertNode(binaryTree, 2);
    insertNode(binaryTree, 3);
    insertNode(binaryTree, 5);
    insertNode(binaryTree, 2);
//    insertNode(binaryTree, 2);

//    printTreeInorder(binaryTree.root);

    System.out.println(isChildrenSumPropertySatisfied(binaryTree.root));
  }

}
