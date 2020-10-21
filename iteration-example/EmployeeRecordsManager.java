import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class EmployeeRecordsManager {
  
  public static void main(String[] args) {
    //prior to Java 8
    // List<Employee> employeeList = new LinkedList<Employee>();

    // java 8 onwards
     LinkedList<Employee> employeeList = new LinkedList<>();

    employeeList.add(new Employee(1, "Sam", 40000));
    employeeList.add(new Employee(2, "Sourabh", 60000));
    employeeList.add(new Employee(3, "Abhilash", 32000));

    // System.out.println(employeeList);

    // iteration through loops

    // System.out.println("Iteration through For Loop");
    // for(int i=0;i<employeeList.size();i++) {
    //   System.out.println(employeeList.get(i));
    // }

    // iteration through extended for loop
    // System.out.println("Iteration through ForEach Loop");
    // for(Employee empl:employeeList) {
    //   System.out.println(empl);
    // }

    // // iteration through Iterators
    // System.out.println("Iteration through Iterators");
    // Iterator<Employee> itr = employeeList.iterator();
    // while(itr.hasNext()) {
    //   System.out.println(itr.next());
    // }


    // iteration through Iterators
    System.out.println("Iteration through Descending Iterator");
    Iterator<Employee> itr2 = employeeList.descendingIterator();
    while(itr2.hasNext()) {
      System.out.println(itr2.next());
    }
    // iteration through ListIterators
    // System.out.println("Iteration through ListIterators");
    // ListIterator<Employee> listItr = employeeList.listIterator();
    // while(listItr.hasNext()) {
    //   System.out.println(listItr.next());
    // }

    // reverse iteration through ListIterators
    // System.out.println("Reverse Iteration through ListIterators");
    // while(listItr.hasPrevious()) {
    //   System.out.println(listItr.previous());
    // }

    // System.out.println("Iteration through forEach method");
    // employeeList.forEach(System.out::println);
  }
}
