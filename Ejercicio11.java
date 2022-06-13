import java.util.Scanner;

import tads.Coord;
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

            Pair<List<Coord>, Integer> solOpt = new Pair(new List(), Integer.MAX_VALUE);
            Pair<List<Coord>, Integer> solCand = new Pair(new List(new Coord(xi, yi)), matrix[xi][yi]);

            Pair<List<Coord>, Integer> sol = laberintoBT(
                    solOpt,
                    solCand,
                    matrix,
                    new Coord(xi, yi), new Coord(xf, yf));

            System.out.println(sol.value > k ? 0 : sol.value);
        }

        in.close();
    }

    public static Pair<List<Coord>, Integer> laberintoBT(
            Pair<List<Coord>, Integer> solOpt,
            Pair<List<Coord>, Integer> solCand,
            int[][] matrix, Coord origin,
            Coord destiny) throws Exception {
        if (solCand.value > solOpt.value) {
            return solOpt;
        }
        if (origin.x == destiny.x && origin.y == destiny.y) {
            return solCand.value < solOpt.value
                    ? new Pair<List<Coord>, Integer>(solCand.key.clone(), solCand.value)
                    : solOpt;
        }

        int[][] movs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < movs.length; i++) {
            Coord newOrigin = new Coord(origin.x + movs[i][0],
                    origin.y + movs[i][1]);
            int m = matrix.length - 1;
            int n = matrix[0].length - 1;
            if (newOrigin.x >= 1 && newOrigin.x <= m && newOrigin.y >= 1 && newOrigin.y <= n) {
                int weight = matrix[newOrigin.x][newOrigin.y];
                if (weight != 0 && !solCand.key.contains(newOrigin)) {
                    solCand.key.insert(newOrigin);
                    solCand.value += weight;
                    solOpt = laberintoBT(solOpt, solCand, matrix, newOrigin, destiny);
                    solCand.key.delete(newOrigin);
                    solCand.value -= weight;
                }
            }
        }

        return solOpt;
    }
}
