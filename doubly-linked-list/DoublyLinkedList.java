
public class DoublyLinkedList {

  Node START, LAST;

  public DoublyLinkedList() {
    START = null;
    LAST = null;
  }

  public void traverse() {
    Node currentNode = START;
    if(START==null) {
      System.out.println("List is empty");
    }
    while(currentNode!=null) {
      System.out.print(currentNode.data+" ");
      currentNode = currentNode.next;
    }
    System.out.println();
  }

  public void reverseTraverse() {
    Node currentNode = LAST;
    if(LAST==null) {
      System.out.println("List is empty");
    }
    while(currentNode!=null) {
      System.out.print(currentNode.data+" ");
      currentNode = currentNode.prev;
    }
    System.out.println();
  }

  public void insert(int item) {
    Node newNode = new Node();
    newNode.data = item;
    if(START==null) {
      newNode.next = null;
      newNode.prev = null;
      START = newNode;
    } else {
      Node current, previous;
      current = START;
      previous = null;
      while(current!=null && current.data<item) {
        previous = current;
        current = current.next;
      }

      newNode.next = current;
      newNode.prev = previous;
      if(current!=null) {
      current.prev = newNode;
      } else {
        LAST = newNode;
      }
      if(previous!=null) {
        previous.next = newNode;
      }
      // if the new element is the first element in the list, START should
      //point to it 
      else {
        START = newNode;
      }
    }
  }

  public void delete(int element) {
     Node previous, current;
     previous = null;
     current = START;
     while(current!=null && current.data!=element) {
       previous = current;
       current = current.next;
     } 
     if(current == null) {
       System.out.println("Value to be deleted in not found");
       return;
     }
     // the element to be deleted is not the first element
     if(previous!=null) {
       previous.next = current.next;
     }
     // if first element is to be deleted
     else {
      START = START.next;
     }
     // if the element to be deleted is not the last element
     if(current.next!=null) {
        current.next.prev = previous;
     }
  }

  
  
}
