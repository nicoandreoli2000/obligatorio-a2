import java.util.Scanner;

import tads.OpenHashMap;

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        Integer n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        System.out.println(ejercicio1(n, s));
        in.close();
    }

    public static Integer ejercicio1(Integer n, String s) throws Exception {
        var hash = new OpenHashMap<Character, Integer>(n);
        int amount = 0;
        for (int i = 0; i < s.length(); i++) {
            char pos = s.charAt(i);
            int value = 1;
            if (i % 2 != 0) {
                pos = Character.toLowerCase(pos);
                if (!hash.contains(pos)) {
                    amount++;
                } else {
                    value = hash.get(pos);

                    hash.delete(pos);
                    if (value > 1) {
                        hash.insert(pos, value - 1);
                    }
                }
            } else {
                if (hash.contains(pos)) {
                    value += hash.get(pos);
                }

                hash.delete(pos);
                hash.insert(pos, value);
            }
        }
        return amount;
    }
}
