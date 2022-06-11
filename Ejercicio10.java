import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) throws Exception {
        ejercicio10();
    }

    public static void ejercicio10() throws Exception {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        int[] set = new int[n];

        for (int i = 0; i < n; i++) {
            set[i] = Integer.parseInt(in.nextLine());
        }

        int cota = Integer.parseInt(in.nextLine());
        boolean[][] res = subsetSum(set, n, cota);

        int m = Integer.parseInt(in.nextLine());

        for (int i = 0; i < m; i++) {
            int sum = Integer.parseInt(in.nextLine());
            System.out.print(res[i][sum] ? 1 : 0);
            if (i != m - 1) {
                System.out.println();
            }
        }

        in.close();
    }

    public static boolean[][] subsetSum(int set[], int n, int cota) {

        boolean matrix[][] = new boolean[n][cota + 1];

        for (int i = 0; i < n; i++) {
            matrix[i][0] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= cota; j++) {
                if (j >= set[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j] || matrix[i - 1][j - set[i - 1]];
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        return matrix;
    }
}
