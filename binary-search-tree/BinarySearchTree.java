public class BinarySearchTree {

  Node root;

  public BinarySearchTree() {
    this.root = null;
  }

  public void inorderTraversal(Node node) {
    if(node!=null) {
      inorderTraversal(node.lchild);
      System.out.print(node.data+"  ");
      inorderTraversal(node.rchild);
    }
  }

  public void preOrderTraversal(Node node) {
    if(node!=null) {
      System.out.print(node.data+"  ");
      inorderTraversal(node.lchild);
      inorderTraversal(node.rchild);
    }
  }

  public void postOrderTraversal(Node node) {
    if(node!=null) {
      inorderTraversal(node.lchild);
      inorderTraversal(node.rchild);
      System.out.print(node.data+"  ");
    }
  }

  public void search(int item) {
    Node currentNode = root;
 
    while(currentNode!=null) {
      if(item == currentNode.data) {
        System.out.println("Item is found");
        return;
      }
      else if(item<currentNode.data) {
        currentNode = currentNode.lchild;
      } else {
        currentNode = currentNode.rchild;
      }
    }

    if(currentNode == null) {
      System.out.println("Not found");
    }
  }

  public void insert(int item) {
    Node currentNode = root;
    Node parent = null;

    while(currentNode!=null) {
        parent = currentNode;
        if(item<currentNode.data) {
            currentNode = currentNode.lchild;
        } else {
            currentNode = currentNode.rchild;
        }
    }
    Node newNode = new Node(item);
    if(parent==null) {
        root = newNode;
        return;
    }
    if(newNode.data<parent.data) {
        parent.lchild = newNode;
    } else {
        parent.rchild = newNode;
    }
}

  public Node delete(Node node, int item) {
    if(node == null) 
      return node;
    

    if(item < node.data) {
      node.lchild = delete(node.lchild, item);
    } else if(item > node.data) {
      node.rchild = delete(node.rchild, item);
    } else {
      if(node.lchild == null) {
        return node.rchild;
      } else if(node.rchild == null) {
        return node.lchild;
      }

      // if the node to be deleted has both left child and right child
      node.data = findInorderSuccessor(node.rchild);
      node.rchild = delete(node.rchild, node.data);
    }
    return node;
  }


  public static int findInorderSuccessor(Node node) {
    int minimum = (int) node.data;
    while (node.lchild != null) {
        minimum = (int) node.lchild.data;
        node = node.lchild;
    }
    return minimum;
}

  
}
