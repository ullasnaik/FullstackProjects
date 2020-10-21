public class Stack {
  
  Node TOP;

  public Stack() {
    // initially stack would be empty, hence TOP is null
    TOP = null;
  }

  public void push(int item) {

    Node newNode = new Node();
    newNode.data = item;
    // if the stack is empty
    if(TOP == null) {
      newNode.next = null;
    } else {
      newNode.next = TOP;
    }
    TOP = newNode;
  }
  
  public void pop() {
    // Pop functionality could also work without using the tmp variable, but it
    // introduced here just to display the element being popped
    Node tmp;
    // check for stack underflow
    if(TOP == null) {
      System.out.println("Stack is empty");
      return;
    }
    // if the stack is not empty, then move top to the next element
    tmp = TOP;
    TOP = TOP.next;
    System.out.println("Element popped:"+tmp.data);
  }
  
  // this is not an usual operation in stack, but used in the example, just
  // to understand the current position of the stack
  public void traverse() {

    Node current = TOP;
    while(current!=null) {
      System.out.print(current.data+"  ");
      current = current.next;
    }
    System.out.println();
  }

}
