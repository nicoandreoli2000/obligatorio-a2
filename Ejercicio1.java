import java.util.Scanner;

import tads.OpenHashMap;

public class Ejercicio1 {
    public static void main(String[] args) {
        try (var in = new Scanner(System.in)) {
            Integer n = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            System.out.println(ejercicio1(n, s));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static Integer ejercicio1(Integer n, String s) {
        var hash = new OpenHashMap<Integer, Integer>(n);
        int amount = 0;
        for (int i = 0; i < s.length(); i++) {
            var pos = (int) s.charAt(i);
            if (i % 2 == 0) {
                if (!hash.contains(pos)) {
                    amount++;
                } else {
                    hash.delete(pos);

                }
            } else {
                hash.insert(pos, 1);
            }
        }
        return amount;
    }
}
