public class BinaryTree {

  Node root;

  public BinaryTree() {
    root = null;
  }

  public Node insert(Node node, int data) {
    if(node ==null) {
        node = new Node(data);
        if(root == null) {
          root = node;
        } 
        return node;
    }
    if(node.left!=null) {
      node.right = insert(node.right, data);
    } else {
      node.left = insert(node.left, data);
    }
    return node;
  }

  public void inorderTraversal(Node node) {
    if(node!=null) {
      inorderTraversal(node.left);
      System.out.print(node.element+"  ");
      inorderTraversal(node.right);
    }
  }

  public void preOrderTraversal(Node node) {
    if(node!=null) {
      System.out.print(node.element+"  ");
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
    }
  }

  public void postOrderTraversal(Node node) {
    if(node!=null) {
      
      postOrderTraversal(node.left);
      postOrderTraversal(node.right);
      System.out.print(node.element+"  ");
    }
  }

}
