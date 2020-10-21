public class Main {

  public static void main(String[] args) {
    
    BinaryTree tree = new BinaryTree();
    // tree.root = new Node(10);
    // tree.root.left = new Node(20);
    // tree.root.right = new Node(30);
    // tree.root.left.left = new Node(40);
    // tree.root.left.right = new Node(50);
    // tree.root.right.left = new Node(60);
    // tree.root.right.right = new Node(70);

    tree.insert(tree.root, 10);
    tree.insert(tree.root, 20);
    tree.insert(tree.root, 30);
    tree.insert(tree.root, 40);
    tree.insert(tree.root, 50);
    
    tree.inorderTraversal(tree.root);
    System.out.println();

    tree.preOrderTraversal(tree.root);
    System.out.println();

    tree.postOrderTraversal(tree.root);
    System.out.println();
  }
  
}
