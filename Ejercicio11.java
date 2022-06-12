import java.util.Scanner;

import tads.List;
import tads.Pair;

public class Ejercicio11 {
    public static void main(String[] args) throws Exception {
        ejercicio11();
    }

    public static void ejercicio11() throws Exception {
        Scanner in = new Scanner(System.in);

        String[] dimensions = in.nextLine().split(" ");

        int m = Integer.parseInt(dimensions[0]);
        int n = Integer.parseInt(dimensions[1]);

        int k = Integer.parseInt(in.nextLine());

        int[][] matrix = new int[m + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            String[] line = in.nextLine().split(" ");
            for (int i = 1; i <= m; i++) {
                matrix[i][j] = Integer.parseInt(line[i - 1]);
            }
        }

        int p = Integer.parseInt(in.nextLine());

        for (int i = 0; i < p; i++) {
            String[] line = in.nextLine().split(" ");
            int xi = Integer.parseInt(line[0]);
            int yi = Integer.parseInt(line[1]);
            int xf = Integer.parseInt(line[2]);
            int yf = Integer.parseInt(line[3]);

            Pair<List<Pair<Integer, Integer>>, Integer> solOpt = new Pair(new List(), Integer.MAX_VALUE);
            Pair<List<Pair<Integer, Integer>>, Integer> solCand = new Pair(new List(new Pair(xi, yi)), matrix[xi][yi]);

            Pair<List<Pair<Integer, Integer>>, Integer> sol = laberintoBT(
                    solOpt,
                    solCand,
                    matrix,
                    new Pair<Integer, Integer>(xi, yi), new Pair<Integer, Integer>(xf, yf));

            System.out.println(sol.value > k ? 0 : sol.value);
        }

        in.close();
    }

    public static Pair<List<Pair<Integer, Integer>>, Integer> laberintoBT(
            Pair<List<Pair<Integer, Integer>>, Integer> solOpt,
            Pair<List<Pair<Integer, Integer>>, Integer> solCand,
            int[][] matrix, Pair<Integer, Integer> origin,
            Pair<Integer, Integer> destiny) throws Exception {
        if (solCand.value > solOpt.value) {
            return solOpt;
        }
        if (origin.key == destiny.key && origin.value == destiny.value) {
            return solCand.value > solOpt.value ? solOpt : solCand;
        }

        int[][] movs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < movs.length; i++) {
            Pair<Integer, Integer> newOrigin = new Pair<Integer, Integer>(origin.key + movs[i][0],
                    origin.value + movs[i][1]);
            int m = matrix.length - 1;
            int n = matrix[0].length - 1;
            if (newOrigin.key >= 1 && newOrigin.key <= m && newOrigin.value >= 1 && newOrigin.value <= n) {
                // System.out.print("Origen: " + newOrigin.key + "-" + newOrigin.value);
                int weight = matrix[newOrigin.key][newOrigin.value];
                if (weight != 0 && !solCand.key.contains(newOrigin)) {
                    solCand.key.insert(newOrigin);
                    solCand.value += weight;
                    solOpt = laberintoBT(solOpt, solCand, matrix, newOrigin, destiny);
                    solCand.key.delete(newOrigin);
                    solCand.value = weight;
                }
            }
        }

        // System.out.println(solOpt.key.toString());

        return solOpt;
    }
}
