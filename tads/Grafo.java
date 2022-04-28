package tads;

import java.util.Iterator;

public class Grafo<T> implements Iterable<T> {
    private Node root;

    private class Node {
        T data;
        List<Pair<T, Integer>> ady;
        Node next;
    }

    public void add(T elem) {
        root = add(elem, root);
    }

    public void add(T elem, Pair<T, Integer> ady) {
        root = add(elem, ady, root);
    }

    public void deleteNode(T elem) {
        root = deleteNode(elem, root);
    }

    public void deleteAdy(T elem, Pair<T, Integer> ady) {
        root = deleteAdy(elem, ady, root);
    }

    public boolean exist(T elem) {
        return exist(elem, root);
    }

    public List<T> getNodes() {
        return getNodes(root);
    }

    public List<Pair<T, Integer>> getAdys(T elem) {
        return getAdys(elem, root);
    }

    public Integer getGrad(T elem) {
        return getGrad(elem, root);
    }

    public T get() {
        return get(root);
    }

    /*
     * si el grafo es no dirigido ambos vertices adyacentes se tienen como
     * adyacente,
     * 
     * -add(Node data) crea el vertice sin adyacentes
     * -add(Node data, Integer ady) añade al vertice una arista, si no existe el
     * vertice lo crea, si no existe el vertice adyacente no hace nada
     * -deleteNode(Node node) borra un vertice
     * -deleteAdy(Node data, Integer ady) borra una arista
     * -exist(Node data) si existe el nodo = true, sino false
     * -getNodes() devuelve la lista de nodos
     * -getAdys(Node node) devuelve la lista de adyacentes del nodo
     * -getGrad(Node node) devuelve el grado del vertice, -1 si el vertice no existe
     * -getData() devuelve el valor del nodo
     * 
     * en el iterator
     * -hasNext()
     * -next()
     * ...
     */

    private T get(Grafo<T>.Node root2) {
        if (root2 == null)
            return null;
        else
            return root2.data;
    }

    private Integer getGrad(T elem, Grafo<T>.Node root2) {
        if (exist(elem)) {
            Integer grad = 0;
            var it = root2.ady.iterator();
            var it2 = iterator();
            while (it2.hasNext()) {
                while (it.hasNext()) {
                    if (it.next().fst() == elem)
                        grad++;
                }
            }
            return grad;
        }
        return -1;
    }

    private List<Pair<T, Integer>> getAdys(T elem, Grafo<T>.Node root2) {
        if (root2 == null)
            return null;
        else if (get(root2) == elem)
            return root2.ady;
        else
            return getAdys(elem, root2.next);
    }

    private List<T> getNodes(Grafo<T>.Node root2) {
        if (root2 == null)
            return null;
        else {
            Iterator<T> it = iterator();
            List<T> ln = new List<T>();
            while (it.hasNext()) {
                ln.insert(it.next());
            }
            return ln;
        }
    }

    private Grafo<T>.Node deleteAdy(T elem, Pair<T, Integer> ady, Grafo<T>.Node root2) {
        if (root2 == null)
            return root2;
        else if (get(root2) == elem) {
            root2.ady.delete(ady);
            return root2;
        } else
            return deleteAdy(elem, ady, root2.next);
    }

    private Grafo<T>.Node deleteNode(T elem, Grafo<T>.Node root2) {
        if (root2 == null)
            return root2;
        else if (get(root2) == elem) {
            root2 = root2.next;
            return root2;
        } else
            return deleteNode(elem, root2.next);
    }

    private boolean exist(T elem, Grafo<T>.Node root2) {
        if (root2 == null)
            return false;
        else if (get(root2) == elem)
            return true;
        else
            return exist(elem, root2.next);
    }

    private Grafo<T>.Node add(T elem, Pair<T, Integer> ady, Grafo<T>.Node root2) {
        if (root2 == null) {
            Node newNode = new Node();
            newNode.data = elem;
            newNode.ady.insert(ady);
            newNode.next = root2;
            root2 = newNode;
            return root2;
        } else if (get(root2) == elem) {
            if (!root2.ady.contains(ady)) {
                root2.ady.insert(ady);
            }
            return root2;
        } else
            return add(elem, ady, root2.next);
    }

    private Grafo<T>.Node add(T elem, Grafo<T>.Node root2) {
        if (root2 == null) {
            Node newNode = new Node();
            newNode.data = elem;
            newNode.next = root2;
            root2 = newNode;
            return root2;
        } else if (get(root2) == elem) {
            return root2;
        } else
            return add(elem, root2.next);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(root);
    }

    private class ListIterator implements Iterator<T> {
        private Node actual;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            T elem = actual.data;
            actual = actual.next;
            return elem;
        }

        public ListIterator(Node start) {
            actual = start;
        }
    }
}
