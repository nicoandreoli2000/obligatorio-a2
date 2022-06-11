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
        int m = Integer.parseInt(in.nextLine());

        for (int i = 0; i < m; i++) {
            int sum = Integer.parseInt(in.nextLine());
            boolean isSubset = isSubset(set, n, sum);
            System.out.print(isSubset ? 1 : 0);
            if (i != m - 1) {
                System.out.println();
            }
        }

        in.close();
    }

    public static boolean isSubset(int set[], int n, int sum) {

        boolean subset[][] = new boolean[sum + 1][n + 1];

        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
            }
        }

        return subset[sum][n];
    }
}
