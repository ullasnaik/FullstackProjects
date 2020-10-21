
public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
//        tree.insert(50);
//        tree.insert(40);
//        tree.insert(30);
//        tree.insert(45);
//        tree.insert(60);
//        tree.insert(70);
//        tree.insert(85);
//        tree.insert(42);

        tree.insert(10);
        tree.insert(7);
        tree.insert(3);
        tree.insert(12);
        tree.insert(14);
        tree.insert(15);
        tree.insert(19);
        tree.insert(22);
        tree.insert(8);
        tree.inorderTraversal(tree.root);

        //tree.search(30);

//        tree.deleteNodeWithTwoChildren(40);
//        System.out.println();
//        tree.inorderTraversal(tree.root);

//        tree.root = tree.delete(tree.root,70);
//        System.out.println();
//        tree.inorderTraversal(tree.root);
//
//        tree.root = tree.delete(tree.root,30);
//        System.out.println();
//        tree.inorderTraversal(tree.root);
//
//        tree.root = tree.delete(tree.root,50);
//        System.out.println();
//        tree.inorderTraversal(tree.root);
//
//        tree.root = tree.delete(tree.root,45);
//        System.out.println();
//        tree.inorderTraversal(tree.root);
//
//        tree.root = tree.delete(tree.root,40);
//        System.out.println();
//        tree.inorderTraversal(tree.root);
//
//        tree.root = tree.delete(tree.root,85);
//        System.out.println();
//        tree.inorderTraversal(tree.root);
//
//        tree.root = tree.delete(tree.root,60);
//        System.out.println();
//        tree.inorderTraversal(tree.root);
//
//        tree.root = tree.delete(tree.root,42);
//        System.out.println();
//        tree.inorderTraversal(tree.root);

        tree.root = tree.delete(tree.root, 12);
        System.out.println();
        tree.inorderTraversal(tree.root);

        tree.root = tree.delete(tree.root, 7);
        System.out.println();
        tree.inorderTraversal(tree.root);

        tree.root = tree.delete(tree.root, 3);
        System.out.println();
        tree.inorderTraversal(tree.root);

        tree.root = tree.delete(tree.root, 10);
        System.out.println();
        tree.inorderTraversal(tree.root);

        tree.root = tree.delete(tree.root, 14);
        System.out.println();
        tree.inorderTraversal(tree.root);
    }
}