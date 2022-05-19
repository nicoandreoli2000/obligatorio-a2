import java.util.Scanner;

import tads.*;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer v = Integer.parseInt(in.nextLine());
        DisJointSet2 dsj = new DisJointSet2(v);
        Integer e = Integer.parseInt(in.nextLine());
        for (int i = 0; i < e; i++) {
            String[] l = in.nextLine().split(" ");
            Integer[] linea = new Integer[l.length];
            for (int j = 0; j < l.length; j++) {
                linea[j] = Integer.parseInt(l[j]);
            }
            dsj.union(linea[0]-1, linea[1]-1);
        }
        System.out.println(dsj.size());
    }
}
