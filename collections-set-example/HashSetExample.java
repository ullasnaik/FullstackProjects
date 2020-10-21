import java.util.HashSet;

public class HashSetExample {

  public static void main(String[] args) {
    
    HashSet<Integer> evenNumbers = new HashSet<>();
    evenNumbers.add(20);
    evenNumbers.add(8);
    evenNumbers.add(2);
    evenNumbers.add(4);
    evenNumbers.add(6);
   
    
    System.out.println(evenNumbers);

    HashSet<Integer> smallEvenNumbers = new HashSet<>();
    smallEvenNumbers.add(8);
    // smallEvenNumbers.add(2);
    smallEvenNumbers.add(4);
    smallEvenNumbers.add(6);
    System.out.println(smallEvenNumbers);
    System.out.println();
    
    evenNumbers.retainAll(smallEvenNumbers);
    System.out.println(evenNumbers);
    System.out.println(smallEvenNumbers);

    
    // this method can be useful to find the subset of another set
    // System.out.println(evenNumbers.containsAll(smallEvenNumbers));

    // evenNumbers.retainAll(smallEvenNumbers);
    // System.out.println(smallEvenNumbers);

    // HashSet<Integer> oddNumbers = new HashSet<>();
    // oddNumbers.add(23);
    // oddNumbers.add(7);
    // oddNumbers.add(3);
    // oddNumbers.add(19);
    // oddNumbers.add(21);
    
    // System.out.println(oddNumbers);

    // oddNumbers.containsAll(c)

    // oddNumbers.addAll(evenNumbers);
    // System.out.println(oddNumbers);


  }
  
}
