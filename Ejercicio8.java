import java.util.Scanner;
import tads.MinHeap;
import tads.Pair;
import utils.MergeSort;

public class Ejercicio8 {
    public static void main(String[] args) throws Exception {
        ejercicio8();
    }

    public static void ejercicio8() throws Exception {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        // O(N)
        Pair<Integer, Integer>[] scheduling = (Pair<Integer, Integer>[]) new Object[n];
        for (int i = 0; i < n; i++) {
            String[] arr = in.nextLine().split(" ");
            int from = Integer.parseInt(arr[0]);
            int to = Integer.parseInt(arr[1]);
            scheduling[i] = new Pair<Integer, Integer>(from, to);
        }

        // O(N.log(N))
        MergeSort.sort(scheduling, 0, n - 1);

        // O(N.?)
        int min = 1;
        // TODO: https:
        // //github.com/SleekPanther/interval-partitioning-greedy-algorithm/blob/master/IntvlPart.java
        // MinHeap<Integer[]> heap = new MinHeap<Integer[]>(n);
        // heap.push(0, scheduling[0].value);
        // for (int i = 1; i < n; i++) {
        // Pair<Integer, Integer> interval = heap.top();
        // heap.pop();
        // if (scheduling[i].key > interval.value) {

        // }
        // }

        System.out.println(min);

        in.close();

    }
}