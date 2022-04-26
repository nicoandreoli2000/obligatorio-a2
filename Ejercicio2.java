import java.util.Scanner;

import tads.OpenHashMap;

public class Ejercicio2 {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        Integer n = Integer.parseInt(in.nextLine());
        System.out.println(ejercicio2(n, in));
        in.close();
    }

    public static String ejercicio2(Integer n, Scanner in) throws Exception {
        var hash = new OpenHashMap<String, Integer>(n);
        int maxAmountOfPoints = 0;
        String personWithMaxAmountOfPointsFirst = "";
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            String name = arr[0];
            int points = Integer.parseInt(arr[1]);
            System.out.print(name);
            System.out.print(points);

            if (hash.contains(name)) {
                int prevPoints = hash.get(name);
                int newPoints = prevPoints + points;
                if (newPoints > maxAmountOfPoints) {
                    maxAmountOfPoints = newPoints;
                    personWithMaxAmountOfPointsFirst = name;
                }
                hash.delete(name);
                hash.insert(name, newPoints);
            } else {
                if (points > maxAmountOfPoints) {
                    maxAmountOfPoints = points;
                    personWithMaxAmountOfPointsFirst = name;
                }
                hash.insert(name, points);
            }
        }
        return personWithMaxAmountOfPointsFirst;
    }
}
