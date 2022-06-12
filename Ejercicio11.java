import java.util.Scanner;

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

        int matrix[][] = new int[m + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            String[] line = in.nextLine().split(" ");
            for (int i = 0; i < m; i++) {
                matrix[i][j] = Integer.parseInt(line[i]);
            }
        }

        int p = Integer.parseInt(in.nextLine());

        for (int i = 0; i < p; i++) {
            String[] line = in.nextLine().split(" ");
            int xi = Integer.parseInt(line[0]);
            int yi = Integer.parseInt(line[1]);
            int xf = Integer.parseInt(line[2]);
            int yf = Integer.parseInt(line[3]);
            int costoMin = laberintoBT(matrix, xi, yi, xf, yf);
            System.out.println(costoMin > k ? 0 : costoMin);
        }

        in.close();
    }

    public static int laberintoBT(int[][] matrix, int xi, int yi, int xf, int yf) {
        return 0;
    }
}
