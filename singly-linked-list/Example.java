public class Example {

  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    list.traverse();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(25);
    list.add(5);
    System.out.println("After adding all elements");
    list.traverse();
    System.out.println("Attempting to delete 7");
    list.delete(7);
    list.delete(25);
    System.out.println("After deleting 25");
    list.traverse();
    list.delete(50);
    System.out.println("After deleting 50");
    list.traverse();
    list.delete(5);
    System.out.println("After deleting 5");
    list.traverse();

    System.out.println("After searching for 40");
    list.search(40);

    System.out.println("After searching for 8");
    list.search(8);
  }
  
}
