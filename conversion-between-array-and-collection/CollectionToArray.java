import java.util.ArrayList;
import java.util.List;

public class CollectionToArray {
  
  public static void main(String[] args) {

    List<String> wordList = new ArrayList<>();
    wordList.add("this");
    wordList.add("is");
    wordList.add("a");
    wordList.add("sample");
    wordList.add("string");

    System.out.println(wordList);

    String[] words = wordList.toArray(new String[0]);
    for(String word:words) {
      System.out.println(word);
    }

    
  }
}
