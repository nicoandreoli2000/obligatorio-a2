import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        ejercicio8();
    }

    public static void ejercicio8() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int min = 1;
        for (int i = 0; i < n; i++) {
            String[] arr = in.nextLine().split(" ");
            int from = Integer.parseInt(arr[0]);
            int to = Integer.parseInt(arr[1]);
            // logic
        }
        System.out.println(min);
        in.close();

    }
}