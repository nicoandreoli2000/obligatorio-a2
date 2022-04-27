import java.util.Scanner;

import tads.AVL;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer k = Integer.parseInt(in.nextLine());
        Integer size = Integer.parseInt(in.nextLine());
        AVL<Integer> a = new AVL<Integer>();
        for (int i = 0; i < size; i++) {
            Integer next = Integer.parseInt(in.nextLine());
            a.insert(next);
        }
        ejercicio3(k, a);
    }

    public static void ejercicio3(Integer k, AVL<Integer> l) {
        for (int i = 0; i < k; i++) {
            Integer max = l.maximo();
            System.out.println(max);
            l.delete(max);
        }
    }
}
