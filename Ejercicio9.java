import java.math.BigInteger;
import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        ejercicio9();
    }

    private static void ejercicio9() {
        Scanner in = new Scanner(System.in);
        int cota = Integer.parseInt(in.nextLine());
        BigInteger[] memory = new BigInteger[cota + 1];
        memory[0] = BigInteger.ONE;
        for (int i = 1; i <= cota; i++) {
            memory[i] = memory[i - 1].multiply(BigInteger.valueOf(i));
        }
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] arr = in.nextLine().split(" ");
            int p = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);
            BigInteger res = memory[p].divide(memory[k].multiply(memory[p - k]));
            System.out.println(res);
        }
        in.close();
    }

}