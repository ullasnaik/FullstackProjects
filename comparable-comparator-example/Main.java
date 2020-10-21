import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    
    List<Integer> values = Arrays.asList(new Integer[]{5,3,2,8,9});
    System.out.println(values);
    Collections.sort(values);
    System.out.println(values);
  }
  
}
