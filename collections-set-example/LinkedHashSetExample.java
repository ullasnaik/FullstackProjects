import java.util.LinkedHashSet;

public class LinkedHashSetExample {
  
  public static void main(String[] args) {
    LinkedHashSet<Integer> evenNumbers = new LinkedHashSet<>();
    evenNumbers.add(20);
    evenNumbers.add(8);
    evenNumbers.add(2);
    evenNumbers.add(4);
    evenNumbers.add(6);
    evenNumbers.add(23);

    System.out.println(evenNumbers);
  }

}
