import java.util.Scanner;
import javax.lang.model.type.NullType;
import tads.MinHeap;
import tads.Pair;

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
        sort(scheduling, 0, n - 1);

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

    public static void merge(Pair<Integer, Integer>[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Pair<Integer, Integer>[] L = new Pair[n1];
        Pair<Integer, Integer>[] R = new Pair[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].key <= R[j].key) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(Pair<Integer, Integer>[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
}