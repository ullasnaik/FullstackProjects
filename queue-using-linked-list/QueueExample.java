public class QueueExample {
  
  public static void main(String[] args) {
    
    Queue queue = new Queue();
    queue.insert(10);
    queue.insert(20);
    queue.insert(30);
    queue.traverse();
    queue.remove();
    queue.remove();
    queue.traverse();
    queue.remove();
    queue.remove();
  }
}
