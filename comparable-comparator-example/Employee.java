public class Employee implements Comparable<Employee> {

  private int empId;
  private String name;
  private double salary;
  private int age;

  public Employee(int empId, String name, double salary, int age) {
    this.empId = empId;
    this.name = name;
    this.salary = salary;
    this.age = age;
  }

  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Employee [age=" + age + ", empId=" + empId + ", name=" + name + ", salary=" + salary + "]\n";
  }

  @Override
  public int compareTo(Employee emp) {
    return (int) (emp.getSalary() - this.getSalary());
  }  
  
}
