import tads.OpenHashMap;

public class Main {
  public static void main(String[] args) {
    var test = Ejercicio1(3, "dBcDaCxL");
    System.out.println(test);
  }

  public static Integer Ejercicio1(Integer n, String s) {
    var hash = new OpenHashMap<Integer, Integer>(n);
    int amount = 0;
    for(int i = 0; i < s.length(); i++) {
      var pos = (int)s.charAt(i);
      if (i%2 == 0) {
        if(!hash.contains(pos)) {
          amount++;
        }
      } else {
        hash.insert(pos, 1);
      }
    }
    return amount;
  }
}