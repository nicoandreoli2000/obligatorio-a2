package tads;

public class DisjointSet {
    private int[] parent;
    private int[] rank;
    private int size;

    public DisjointSet(int n) {
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

}
