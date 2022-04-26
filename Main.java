import java.util.Scanner;
import tads.*;

public class Main {
    public static void main(String[] args) {
        //Ejercicio1.ejercicio1(10, "iLcPcKlRyCbCbJnBpB");
        try (Scanner in = new Scanner(System.in)) {
            Integer k = Integer.parseInt(in.nextLine());
            Integer size = Integer.parseInt(in.nextLine());
            AVL<Integer> a = new AVL<Integer>();
            // while(in.hasNext()){
            // Integer next = Integer.parseInt(in.nextLine());
            // a.insert(next);
            // }
            for (int i = 0; i < size; i++) {
                Integer next = Integer.parseInt(in.nextLine());
                a.insert(next);
            }
            ejercicio3(k, a);
            // a.inOrderPrint();
        } catch (NumberFormatException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void ejercicio3(Integer k, AVL<Integer> l) {
        for (int i = 0; i < k; i++) {
            Integer max = l.maximo();
            System.out.println(max);
            l.delete(max);
        }
    }
}
