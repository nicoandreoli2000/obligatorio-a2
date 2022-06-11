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
        boolean[][] res = subset(set, n, cota);

        int m = Integer.parseInt(in.nextLine());

        for (int i = 0; i < m; i++) {
            int sum = Integer.parseInt(in.nextLine());
            System.out.print(res[sum][i] ? 1 : 0);
            if (i != m - 1) {
                System.out.println();
            }
        }

        in.close();
    }

    public static boolean[][] subset(int set[], int n, int cota) {

        boolean subset[][] = new boolean[cota + 1][n + 1];

        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        for (int i = 1; i <= cota; i++)
            subset[i][0] = false;

        for (int i = 1; i <= cota; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
            }
        }

        return subset;
    }
}
