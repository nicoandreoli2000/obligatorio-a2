package tads;

public class Grafo<T extends Comparable<T>> {
    private Integer e = 1;
    private Integer expectedSize = 0;
    private Integer size = 0;

    private AVL<T> root = new AVL<T>();
    private Object[][] adys;

    public void add(T elem) {
        root = add(elem, root);
    }

    public void add(T elem, Pair<T, Integer> ady) {
        add(elem, ady, root);
    }

    public void deleteNode(T elem) {
        deleteNode(elem, root);
    }

    public void deleteAdy(T elem, Pair<T, Integer> ady) {
        deleteAdy(elem, ady, root);
    }

    public boolean exist(T elem) {
        return exist(elem, root);
    }

    public Object[] getNodes() {
        return getNodes(root);
    }

    public Object[] getAdys(T elem) {
        return getAdys2(elem);
    }

    public Integer getGrad(T elem) {
        return getGrad(elem, root);
    }

    public T get() {
        return get(root);
    }

    public Integer getSize() {
        return size;
    }

    public AVL<T> getAVL(){
        return root;
    }

    private T get(AVL<T> root2) {
        if (root2 == null)
            return null;
        else
            return root2.get();
    }

    private Integer getGrad(T elem, AVL<T> root2) {
        if (root2.exists(elem)) {
            Integer grad = 0;
            Object[] nodes = getNodes(root2);
            for (int i = 0; i < nodes.length && nodes[i] != null; i++) {
                Object[] adys = getAdys((T) nodes[i]);
                for (int j = 0; j < adys.length; j++) {
                    if (((Pair<T, Integer>) adys[j]).fst().equals(elem))
                        grad++;
                }
            }
            return grad;
        }
        return -1;
    }

    private Object[] getAdys2(T elem) {
        return adys[(Integer) elem -1];
    }

    private Object[] getNodes(AVL<T> root2) {
        return root2.getNodes();        
    }

    private void deleteAdy(T elem, Pair<T, Integer> ady, AVL<T> root2) {
        if(adys[(Integer) elem -1]==null) return;
        else{
            Integer pos = getPos(adys[(Integer) elem -1], ady);
            if (pos != -1)
            adys[(Integer) elem -1] = back(adys[(Integer) elem -1], pos);
        }
    }

    private void deleteNode(T elem, AVL<T> root2) {
        root2.delete(elem);
    }

    private boolean exist(T elem, AVL<T> root2) {
        return root2.exists(elem);
    }

    private void add(T elem, Pair<T, Integer> ady, AVL<T> root2) {
        if(adys==null) adys = createAdys();
        if(adys[(Integer) elem-1] == null) adys[(Integer) elem-1] = createArrayObject();
        Integer lastP = lastPos(adys[(Integer) elem-1]);
        if(lastP != -1) adys[(Integer) elem-1][lastP] = ady; // ady tiene que ser un object o anda si es un pair???
        else{
            e++;
            Object[] ad = createArrayObject();
            ad = copyArray(adys[(Integer) elem-1], ad);
            adys[(Integer) elem-1] = ad;
            lastP = lastPos(adys[(Integer) elem-1]);
            adys[(Integer) elem-1][lastP] = ady;
        }
    }

    private AVL<T> add(T elem, AVL<T> root2) {
        root2.insert(elem);
        size++;
        return root2;
    }

    private Object[][] createAdys(){
        Object[][] newAdys = new Object[expectedSize][];
        return newAdys;
    }

    private boolean existAdy(Object[] ad, T elem) {
        if (ad == null)
            return false;
        else {
            for (int i = 0; i < ad.length && ad[i] != null; i++) {
                Pair<Integer, Integer> p = (Pair<Integer, Integer>) ad[i];
                if (p.fst().equals(elem))
                    return true;
            }
        }
        return false;
    }

    private Integer lastPos(Object[] ad) {
        for (int i = 0; i < ad.length; i++) {
            if (ad[i] == null)
                return i;
        }
        return -1;
    }

    private Integer getPos(Object[] ad, Pair<T, Integer> p) {
        for (int i = 0; i < ad.length; i++) {
            if (ad[i] == p)
                return i;
        }
        return -1;
    }

    private Object[] back(Object[] ad, Integer pos) {
        for (int i = pos; i < ad.length - 1; i++) {
            ad[i] = ad[i + 1];
        }
        ad[ad.length - 1] = null;
        return ad;
    }

    private Object[] createArrayObject() {
        Object[] ad = new Object[7 * e];
        return ad;
    }

    private Object[] copyArray(Object[] o1, Object[] o2) {
        for (int i = 0; i < o1.length; i++) {
            o2[i] = o1[i];
        }
        return o2;
    }

    public void setExpectedSize(Integer size){
        expectedSize = size;
    }

}
