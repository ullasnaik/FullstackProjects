import java.util.TreeSet;

public class TreeSetExample {
  
  public static void main(String[] args) {
    
    TreeSet<Integer> evenNumbers = new TreeSet<>();
    evenNumbers.add(20);
    evenNumbers.add(8);
    evenNumbers.add(2);
    evenNumbers.add(4);
    evenNumbers.add(6);
    evenNumbers.add(23);
    
    System.out.println(evenNumbers);

    TreeSet<Integer> oddNumbers = new TreeSet<>();
    oddNumbers.add(23);
    oddNumbers.add(7);
    oddNumbers.add(3);
    oddNumbers.add(19);
    oddNumbers.add(21);
    System.out.println(oddNumbers);

    oddNumbers.addAll(evenNumbers);

    System.out.println(oddNumbers);

    System.out.println("First element:"+ oddNumbers.first());
    System.out.println("Last element:"+ oddNumbers.last());

    System.out.println("Higher element:"+ oddNumbers.higher(5));
    System.out.println("Lower element:"+ oddNumbers.lower(5));

    System.out.println("Ceiling:"+ oddNumbers.ceiling(5));
    System.out.println("Floor:"+ oddNumbers.floor(5));

    System.out.println("Head Set:"+ oddNumbers.headSet(8));
    System.out.println("Head Set:"+ oddNumbers.headSet(8,true));
    System.out.println("Tail set:"+ oddNumbers.tailSet(8));
    System.out.println("Tail set:"+ oddNumbers.tailSet(8,false));

    System.out.println(oddNumbers);
    System.out.println(oddNumbers.pollFirst());
    System.out.println(oddNumbers);
    System.out.println(oddNumbers.pollLast());
    System.out.println(oddNumbers);
  }
}
