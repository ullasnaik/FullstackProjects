import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
  
  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>(); 
    map.put(40, "Shujaat");
    map.put(2, "Shivam");
    map.put(19, "Abhishek");
    map.put(3, "Sai");
    

    System.out.println(map);
    // System.out.println(map.containsKey(2));

    // map.put(2, "Sumeet");
    // System.out.println(map);

    // System.out.println(map.containsValue("Shujaat"));

    // String name = map.get(1).toLowerCase();
    // System.out.println(name);
    // map.put(1, name);
    // System.out.println(map);

    // map.remove(3);
    // System.out.println(map);

    // //map.clear();
    // System.out.println("Size:"+map.size());
    // System.out.println("Is Empty:"+map.isEmpty());

    // System.out.println(map.keySet());
    // System.out.println(map.values());
    // System.out.println(map.entrySet());

    // // iteration through map

    // for(Map.Entry entry:map.entrySet()) {
    //   System.out.println(entry.getValue());
    // }

    // Sorting
    Map<Integer,String> treeMap = new TreeMap<>();
    treeMap.putAll(map);
    System.out.println(treeMap);

  }
}