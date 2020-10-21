

public class Queue {

  private Node FRONT;
  private Node REAR;

  // during initialization of the queue, the queue would be empty and hence
  // FRONT and REAR would be empty as well
  public Queue() {
    FRONT = null;
    REAR = null;
  }

  public void insert(int item) {
    Node newNode = new Node();
    newNode.data = item;
    newNode.next = null;
    // checking if queue is empty
    if(REAR == null) {
      FRONT = newNode;
      REAR = newNode;
    } else {
      REAR.next = newNode;
      REAR = newNode;
    }
  }

  public void remove() {
    if(FRONT==null) {
      System.out.println("Queue is empty");
      return;
    }
    Node tmp = FRONT;
    FRONT = FRONT.next;
    System.out.println("Element removed:"+tmp.data);
  }

// this is not a fundamental operation of the queue, but used in this example
// understand current position of the queue
  public void traverse() {
    Node current;
    if(FRONT==null) {
      System.out.println("Queue is empty");
      return;
    }
    current = FRONT;
    while(current!=null) {
      System.out.print(current.data+" ");
      current = current.next;
    }
    System.out.println();
  }
  
}
