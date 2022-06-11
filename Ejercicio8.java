import java.util.Scanner;

import javax.lang.model.type.NullType;

import tads.List;
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
        Pair<Integer, Integer>[] scheduling = new Pair[n];

        // O(N)
        for (int i = 0; i < n; i++) {
            String[] arr = in.nextLine().split(" ");
            int from = Integer.parseInt(arr[0]);
            int to = Integer.parseInt(arr[1]);
            scheduling[i] = new Pair<Integer, Integer>(from, to);
        }

        // O(N.log(N))
        MergeSort.sort(scheduling, 0, n - 1);

        // O(N.log(N))
        MinHeap<NullType> heap = new MinHeap<NullType>(n);
        heap.push(null, scheduling[0].value);
        for (int i = 1; i < n; i++) {
            Pair<NullType, Integer> pair = heap.top();
            if (scheduling[i].key >= pair.value) {
                heap.pop();
                heap.push(null, scheduling[i].value);
            } else {
                heap.push(null, scheduling[i].value);
            }
        }

        System.out.println(heap.size());

        in.close();

    }
}