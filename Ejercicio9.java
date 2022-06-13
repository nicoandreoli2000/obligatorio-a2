import java.math.BigInteger;
import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        ejercicio9b();
    }

    private static void ejercicio9() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }
        int p = in.nextInt();
        String p2 = in.nextLine();
        int a = 0;
        while(in.hasNext()){
            String line = in.nextLine();
            String[] arr = line.split(" ");
            int n1 = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);
            long res = dp[n1]/(dp[k]*(dp[n1-k]));
            System.out.println(res);
            a++;
        }
        in.close();
    }

    private static void ejercicio9b() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger[] dp = new BigInteger[n+1];
        dp[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
        }
        int p = in.nextInt();
        String p2 = in.nextLine();
        int a = 0;
        while(in.hasNext()){
            String line = in.nextLine();
            String[] arr = line.split(" ");
            int n1 = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);
            BigInteger res = dp[n1].divide(dp[k].multiply(dp[n1-k]));
            System.out.println(res);
            a++;
        }
        in.close();
    }

    int fibonacci(int n) {
        int[] tab = new int[n + 1];
        tab[0] = 0;
        tab[1] = 1;
        for (int i = 2; i <= n; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[n];
    }

}