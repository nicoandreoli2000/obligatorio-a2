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

        int c = Integer.parseInt(dimensions[0]);
        int f = Integer.parseInt(dimensions[1]);

        int k = Integer.parseInt(in.nextLine());

        Pair<Integer, Boolean> matrix[][] = new Pair[f + 1][c + 1];

        for (int i = 1; i <= f; i++) {
            String[] line = in.nextLine().split(" ");
            for (int j = 1; j <= c; j++) {
                matrix[i][j] = new Pair<Integer, Boolean>(Integer.parseInt(line[j - 1]), false);
            }
        }

        int p = Integer.parseInt(in.nextLine());

        for (int i = 0; i < p; i++) {
            String[] line = in.nextLine().split(" ");
            int xi = Integer.parseInt(line[0]);
            int yi = Integer.parseInt(line[1]);
            int xf = Integer.parseInt(line[2]);
            int yf = Integer.parseInt(line[3]);

            matrix[xi][yi].value = true;

            Pair<List<Pair<Integer, Integer>>, Integer> solOpt = new Pair(new List(), 0);
            Pair<List<Pair<Integer, Integer>>, Integer> solCand = new Pair(new List(new Pair(xi, yi)), 0);

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
            Pair<Integer, Boolean>[][] matrix, Pair<Integer, Integer> origin,
            Pair<Integer, Integer> destiny) {
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
            int n = matrix.length;
            int m = matrix[0].length;
            if (newOrigin.key >= 1 && newOrigin.key <= m && newOrigin.value >= 1 && newOrigin.value <= n) {
                var pos = matrix[newOrigin.key][newOrigin.value];
                if (pos != null && !pos.value) {
                    pos.value = true;
                    solCand.key.insert(newOrigin);
                    solCand.value += pos.key;
                    solOpt = laberintoBT(solOpt, solCand, matrix, newOrigin, destiny);
                    solCand.key.delete(newOrigin);
                    solCand.value -= pos.key;
                    pos.value = false;
                }
            }
        }

        return solOpt;
    }
}
