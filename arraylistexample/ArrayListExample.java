import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayListExample {

  public static void main(String[] args) {
    
    // initialization
    LinkedList list = new LinkedList();
    list.add(10);
    list.add("Str");
    list.add(7.44);
    list.add(false);
    list.add(10);
    list.addFirst(20);
    list.addLast(30);

    System.out.println(list);

    list.add(1, 'A');

    System.out.println(list);

    list.remove(7.44);

    list.set(1, "Str2");

    System.out.println(list);

    System.out.println("List contains 10:"+ list.contains(10));

    System.out.println("List contains 12:"+ list.contains(12));

    System.out.println(list.get(3));

    System.out.println("Index of element 'A':"+list.indexOf('A'));

    System.out.println("Index of element 'B':"+list.indexOf('B'));

    System.out.println("Is the list empty:" + list.isEmpty());

    System.out.println("Last index of the value 10: "+ list.lastIndexOf(10));
    
    System.out.println(list.size());

    Iterator itr = list.iterator();

    while(itr.hasNext()) {
      Object obj = itr.next();
      System.out.print(obj+"  ");
    }
    System.out.println();

    list.clear();

    System.out.println(list);

    System.out.println("Is the list empty:" + list.isEmpty());

    
    
  }
  
}
