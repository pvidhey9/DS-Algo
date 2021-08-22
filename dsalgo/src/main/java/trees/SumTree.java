package trees;

/* Unlike ChildrenSum property, SumTree condition is when the value of every node is equal to the sum of its entire
* left subtree and right subtree*/

import static trees.BinaryTree.insertNode;

public class SumTree {

  static boolean isSumTree(Node root){

    if(root == null || (root.left == null && root.right == null)){
      return true;
    }

    int leftValue = sum(root.left);
    int rightValue = sum(root.right);

    return (root.key == leftValue + rightValue) && isSumTree(root.left) && isSumTree(root.right);
  }

  static int sum(Node root){
    if(root == null){
      return 0;
    }

    return sum(root.left) + root.key + sum(root.right);
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(26);
    insertNode(binaryTree, 10);
    insertNode(binaryTree, 3);
    insertNode(binaryTree, 4);
    insertNode(binaryTree, 6);
    insertNode(binaryTree, 3);

    System.out.println(isSumTree(binaryTree.root));
  }
}
