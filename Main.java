import tads.OpenHashMap;

public class Main {
  public static void main(String[] args) {
    OpenHashMap<Integer,String> map = new OpenHashMap<Integer, String>(10);
    map.insert(1, "uno");
    map.insert(2, "dos");
    map.insert(3, "tres");

    try{
      System.out.println("key 1: " + map.get(1));
      System.out.println("key 2: " + map.get(2));
      System.out.println("key 3: " + map.get(3));
    } catch(Exception e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }
}