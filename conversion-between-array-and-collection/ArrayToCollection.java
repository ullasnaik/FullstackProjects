import java.util.Arrays;
import java.util.List;

public class ArrayToCollection {

  public static void main(String[] args) {
    
    String[] arr = new String[] {"this","is","a","sample","string"};

    List<String> wordList = Arrays.asList(arr); 
    System.out.println(wordList);
  }
  
}
