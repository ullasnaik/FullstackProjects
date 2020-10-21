public class SinglyLinkedList {

  private Node START;

  public SinglyLinkedList() {
    START = null;
  }

  public void traverse() {
    if(START==null) {
      System.out.println("List is empty!");
    } else {
      Node currentNode = START;
      while(currentNode!=null) {
        System.out.print(currentNode.data+"  ");
        currentNode = currentNode.next;
      }
    }
    System.out.println();
  }

  public void add(int item) {
    // allocate memory for the new item
    Node newNode = new Node();
    //initialize the new node
    newNode.data = item;

      Node currentNode = START;
      Node previous = null;
      while(currentNode!=null && item>=currentNode.data) {
        previous = currentNode;
        currentNode = currentNode.next;
      }
      newNode.next = currentNode;
      // if the new element has to be inserted at the beginning
      if(previous==null) {
        START = newNode;
      } else {
        previous.next = newNode;
      }
  }

  public void delete(int item) {
    Node previous, current;
    previous = null;
    current = START;
    while(current!=null && current.data!=item) {
      previous = current;
      current = current.next;
    }
    //reached the end of the list but could not find the element
    if(current==null) {
      System.out.println("Item not found!!");
    } else {
      //if the first element has to be deleted
      if(current==START) {
        START = START.next;
      } else {
        previous.next = current.next;
      }
    }
  }

  public void search(int item) {
    Node previous, current;
    previous = null;
    current = START;
    while(current!=null && current.data!=item) {
      previous = current;
      current = current.next;
    }
    //reached the end of the list but could not find the element
    if(current==null) {
      System.out.println("Item not found!!");
    } else {
      System.out.println("Item is found");
    }
  }

  
}
