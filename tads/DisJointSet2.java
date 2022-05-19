package tads;

public class DisJointSet2 {
    private int[] parent;
    private int[] rank;
    private int size;

    public DisJointSet2(int n) {
        parent = new int[n];
        rank = new int[n];
        size = n;
        makeSet();
    }

    private void makeSet() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    // devuelve el representante de x
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot)
            return;

        if (rank[xRoot] > rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[xRoot] = yRoot;

            rank[yRoot]++;
        }

        size--;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        DisJointSet2 dsj = new DisJointSet2(6);
        dsj.union(3, 5);
        dsj.union(5, 1);
        int b = dsj.size();
        int a = 0;
    }
}
