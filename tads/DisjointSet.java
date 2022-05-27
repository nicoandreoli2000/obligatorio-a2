package tads;

public class DisjointSet {
    private int[] parent;
    private int size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = n;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        parent[yRoot] = xRoot;
    }

    public int size() {
        return size;
    }

}
