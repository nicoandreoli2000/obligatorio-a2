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
        var hash = new OpenHashMap<Character, Integer>(n);
        int amount = 0;
        for (int i = 0; i < s.length(); i++) {
            char pos = s.charAt(i);
            if (i % 2 != 0) {
                pos = Character.toLowerCase(pos);
                if (!hash.contains(pos)) {
                    amount++;
                } else {
                    int value = 1;
                    try {
                        value = hash.get(pos);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (value > 1) {
                        hash.replace(pos, value - 1);
                    } else {
                        hash.delete(pos);
                    }
                }
            } else {
                int value = 1;
                if (hash.contains(pos)) {

                    try {
                        value = hash.get(pos);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (value > 1) {
                    hash.replace(pos, value - 1);
                } else {
                    hash.insert(pos, value);
                }
            }
        }
        return amount;
    }
}
