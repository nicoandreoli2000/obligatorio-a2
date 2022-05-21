import java.util.Scanner;

import tads.AVL;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        int size = Integer.parseInt(in.nextLine());
        AVL<Integer> a = new AVL<Integer>();
        for (int i = 0; i < size; i++) {
            Integer next = Integer.parseInt(in.nextLine());
            a.insert(next);
        }
        ejercicio3(k, a);
        in.close();
    }

    public static void ejercicio3(int k, AVL<Integer> l) {
        for (int i = 0; i < k; i++) {
            int max = l.maximo();
            System.out.println(max);
            l.delete(max);
        }
    }
}
