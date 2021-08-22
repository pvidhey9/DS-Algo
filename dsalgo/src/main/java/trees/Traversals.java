package trees;

import static trees.BinaryTree.insertNode;
import static trees.BinaryTree.printTreeInorder;

import stacks.Stack;

public class Traversals {

  static int preIndex = 0;

  static void inorderWithoutRecursion(Node root) {
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    Node temp = root;

    while(temp.left != null){
      stack.push(temp.left);
      temp = temp.left;
    }

    while(!stack.isEmpty()) {
      Node topNode = stack.pop();
      System.out.print(topNode.key + " ");

      if(topNode.right != null){
        stack.push(topNode.right);
      }
    }
  }

  static Node buildTreeFromInAndPreorder(int[] in, int[] pre, int inStart, int inEnd) {

    if(inStart > inEnd) {
      return null;
    }

    Node rootNode = new Node(pre[preIndex++]);

    if(inStart == inEnd){
      return rootNode;
    }

    /* This search can be optimized! Push inorder traversal to a map, so that you save on searching for the index
    * for every recursive iteration */
    int inIndex = search(in, rootNode.key, inStart, inEnd);
    rootNode.left = buildTreeFromInAndPreorder(in, pre, inStart, inIndex - 1);
    rootNode.right = buildTreeFromInAndPreorder(in, pre, inIndex + 1, inEnd);

    return rootNode;

  }

  private static int search(int[] in, int key, int inStart, int inEnd) {
    for(int i = inStart; i <= inEnd; i++ ){
      if(in[i] == key){
        return i;
      }
    }
    return -1;
  }

  static void printPostOrder(Node root) {
    if(root == null){
      return;
    }

    printPostOrder(root.left);
    printPostOrder(root.right);
    System.out.print(root.key + " ");
  }

  public static void main(String[] args) {
//    BinaryTree bTree = new BinaryTree(1);
//    bTree.root.left = new Node(2);
//    bTree.root.right = new Node(3);
//
//    insertNode(bTree, 4);
//    insertNode(bTree, 5);
//    System.out.println();
//    inorderWithoutRecursion(bTree.root);

    int in[] = new int[] {4, 2, 1, 5, 3, 6};
    int pre[] = new int[] {1, 2, 4, 3, 5, 6};
    Node constructedTree = buildTreeFromInAndPreorder(in, pre, 0, in.length -1);
    printTreeInorder(constructedTree);
    System.out.println();
    printPostOrder(constructedTree);
  }

}
