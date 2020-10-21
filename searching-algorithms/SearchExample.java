public class SearchExample {

  private static void linearSearch(int[] arr, int item) {

    int listSize = arr.length;
    for(int i=0;i<listSize;i++) {
      if(arr[i]==item) {
        System.out.println("Item found");
        return;
      } 
    }
    System.out.println("Not found");
    
  }

  private static void binarySearch(int[] arr, int item) {

    int size=arr.length;
    int lowerBound = 0;
    int upperBound = size-1;
    int mid;

    while(lowerBound<=upperBound) {
      mid = (lowerBound+upperBound)/2;
      if(arr[mid] == item) {
        System.out.println("Item found");
        return;
      }
      if(item<arr[mid]) {
        upperBound = mid-1;
      }
      if(item>arr[mid]) {
        lowerBound = mid+1;
      }
    }

    System.out.println("Not found");
    
  }



  public static void main(String[] args) {
    
    long start = System.currentTimeMillis();
    binarySearch(new int[] {10,20,30,40,50,70,92,110,115}, 70);
    long end = System.currentTimeMillis();
    System.out.println("Time taken in ms:"+(end-start));

  }
  
}