import java.math.BigInteger;
import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        ejercicio9();
    }

    private static void ejercicio9() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
        }
        in.nextLine();
        in.nextLine();
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            int n1 = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);
            BigInteger res = dp[n1].divide(dp[k].multiply(dp[n1 - k]));
            System.out.println(res);
        }
        in.close();
    }

}