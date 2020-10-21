import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeManager {

  public static void main(String[] args) {
    
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee(1, "Rahul", 56000, 35));
    employees.add(new Employee(2, "Rohan", 42000, 31));
    employees.add(new Employee(3, "Suman", 38000, 28));
    employees.add(new Employee(4, "Raj", 86000, 52));

    System.out.println(employees);
    Collections.sort(employees);
    System.out.println("-----After Sorting---------");
    System.out.println(employees);

    Collections.sort(employees,new EmployeeNameComparator());
    System.out.println("-----After Sorting By Name(Ascending)---------");
    System.out.println(employees);

    Collections.sort(employees,new EmployeeNameComparator().reversed());
    System.out.println("-----After Sorting By Name(descending)---------");
    System.out.println(employees);

    Collections.sort(employees,new EmployeeAgeComparator());
    System.out.println("-----After Sorting By Age(Ascending)---------");
    System.out.println(employees);

    Collections.sort(employees,new EmployeeAgeComparator().reversed());
    System.out.println("-----After Sorting By Age(Descending)---------");
    System.out.println(employees);

  }
  
}
