package trees;

import queues.Queue;

public class BinaryTree {

  Node root;

  public BinaryTree(int key) {
    root = new Node(key);
  }

  /* For Level Order traversal, use a queue! This method is a level order insertion */
  static void insertNode(BinaryTree bTree, int key){

    Node insertNode = new Node(key);
    Queue<Node> nodeQueue = new Queue<>();
    nodeQueue.add(bTree.root);

    while(!nodeQueue.isEmpty()) {
      Node node = nodeQueue.remove();
      if(node.left == null){
        node.left = insertNode;
        return;
      } else {
        nodeQueue.add(node.left);
      }

      if(node.right == null){
        node.right = insertNode;
        return;
      } else {
        nodeQueue.add(node.right);
      }
    }

  }

  /* Left - Root - Right */
  static void printTreeInorder(Node root){
    if(root == null) {
      return;
    }
    printTreeInorder(root.left);
    System.out.print(root.key + " ");
    printTreeInorder(root.right);
  }

  static void deleteNodeInTree(BinaryTree bTree, Node delNode) {

    Queue<Node> nodeQueue = new Queue<>();
    nodeQueue.add(bTree.root);

    while(!nodeQueue.isEmpty()) {
      Node node = nodeQueue.remove();

      if(node == delNode){
        node = null;
        return;
      }

      if(node.right != null) {
        if(node.right == delNode){
          node.right = null;
          return;
        }
      } else {
        nodeQueue.add(node.right);
      }

      if(node.left != null) {
        if(node.left == delNode){
          node.left = null;
          return;
        }
      } else {
        nodeQueue.add(node.left);
      }
    }
  }

  static Node rightMostNode(Node root) {
    if(root == null) {
      return root;
    }

    if(root.right != null) {
      return rightMostNode(root.right);
    } else {
      return root;
    }
  }

  public static void main(String[] args) {
    BinaryTree bTree = new BinaryTree(1);
    bTree.root.left = new Node(2);
    bTree.root.right = new Node(3);

    insertNode(bTree, 4);
    printTreeInorder(bTree.root);
    insertNode(bTree, 5);
    System.out.println();
    printTreeInorder(bTree.root);
    System.out.println();
    insertNode(bTree, 6);
    printTreeInorder(bTree.root);
    System.out.println(rightMostNode(bTree.root).key);
  }
}
