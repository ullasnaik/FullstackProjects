public class MainClass {

  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    list.traverse();
    list.insert(10);
    list.traverse();
    list.insert(20);
    list.traverse();
    list.insert(15);
    list.traverse();
    list.insert(5);
    list.traverse();
    // list.delete(15);
    // list.traverse();
    // list.delete(20);
    // list.traverse();
    // list.delete(5);
    // list.traverse();

    list.reverseTraverse();

  }
  
}
