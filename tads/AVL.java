package tads; // package TAD;

public class AVL<T extends Comparable<T>> {
  AVLNode root;

  private class AVLNode {
    int height;
    AVLNode left, right = null;
    T data;

    AVLNode(T data) {
      this.data = data;
      this.height = 1;
    }
  }

  public int height() {
    return height(root);
  }

  public int size() {
    return size(root);
  }

  public void insert(T data) {
    root = insert(data, root);
  }

  public void delete(T data) {
    root = delete(data, root);
  }

  public boolean exists(T data) {
    return exists(data, root);
  }

  public void inOrderPrint() {
    inOrderPrint(root);
  }

  public T minimo() {
    return minimo(root).data;
  }

  public T maximo() {
    return maximo(root).data;
  }

  public T get() {
    return get(root);
  }

  public void insertT(AVLNode node) {
    root = insertT(node, root);
  }

  private T get(AVLNode node) {
    if (node == null)
      return null;
    else
      return node.data;
  }

  private int height(AVLNode node) {
    if (node != null)
      return node.height;
    else
      return 0;
  }

  private int size(AVLNode node) {
    if (node == null)
      return 0;
    else
      return 1 + size(node.left) + size(node.right);
  }

  private AVLNode insert(T data, AVLNode node) {
    if (node == null)
      return new AVLNode(data);
    if (data.equals(node.data))
      return node;
    if (data.compareTo(node.data) < 0)
      node.left = insert(data, node.left);
    else if (data.compareTo(node.data) > 0)
      node.right = insert(data, node.right);
    node.height = max(height(node.left), height(node.right)) + 1;
    int balance = balanceFactor(node);

    if (balance > 1) {
      // izquierda-izquierda
      if (data.compareTo(node.left.data) < 0)
        return rightRotation(node);
      else
        return leftRightRotation(node);
    } else if (balance < -1) {
      // derecha-derecha
      if (data.compareTo(node.right.data) > 0)
        return leftRotation(node);
      // derecha-izquierda
      else
        return rightLeftRotation(node);
    } else
      return node;
  }

  private AVLNode delete(T data, AVLNode node) {
    boolean b = true;
    if (node == null) {
      return null;
    } else if (data.compareTo(node.data) < 0) {
      node.left = delete(data, node.left);
    } else if (data.compareTo(node.data) > 0) {
      node.right = delete(data, node.right);
    } else if (data.compareTo(node.data) == 0) {
      if (node.left == null && node.right == null) {
        node = node.left;
        b = false;
      } else if (node.left != null && node.right != null) {
        var node_r = node.right;
        node = node.left;
        node = insertT(node_r, node);
      } else if (node.left != null) {
        node = node.left;
      } else if (node.right != null) {
        node = node.right;
      }
    }
    if (b) {
      node.height = max(height(node.left), height(node.right)) + 1;
      int balance = balanceFactor(node);

      if (balance > 1) {
        // izquierda-izquierda
        if (data.compareTo(node.left.data) < 0)
          return rightRotation(node);
        // izquierda-derecha
        else
          return leftRightRotation(node);
      } else if (balance < -1) {
        // derecha-derecha
        if (data.compareTo(node.right.data) > 0)
          return leftRotation(node);
        // derecha-izquierda
        else
          return rightLeftRotation(node);
      } else
        return node;
    }
    return node;
  }

  private AVLNode insertT(AVLNode node, AVLNode root) {
    if (node == null) {
      return null;
    } else {
      root = insert(node.data, root);
      AVLNode aux = insertT(node.left, root);
      if (aux != null)
        root = aux;
      aux = insertT(node.right, root);
      if (aux != null)
        root = aux;
      return root;
    }
  }

  private boolean exists(T data, AVLNode node) {
    if (node == null)
      return false;
    if (node.data.equals(data))
      return true;
    else
      return exists(data, node.left) || exists(data, node.right);
  }

  private int max(int a, int b) {
    if (a > b)
      return a;
    else
      return b;
  }

  private int balanceFactor(AVLNode node) {
    return height(node.left) - height(node.right);
  }

  private AVLNode rightRotation(AVLNode z) {
    var y = z.left;
    var y_r = y.right;

    y.right = z;
    z.left = y_r;

    z.height = max(height(z.left), height(z.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    return y;
  }

  private AVLNode leftRotation(AVLNode z) {
    var y = z.right;

    var y_l = y.left;

    y.left = z;
    z.right = y_l;

    z.height = max(height(z.left), height(z.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    return y;
  }

  private AVLNode leftRightRotation(AVLNode z) {
    var y = z.left;
    var x = y.right;
    var x_l = x.left;

    y.right = x_l;
    z.left = x;
    x_l = y;

    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(y.right)) + 1;

    return rightRotation(z);
  }

  private AVLNode rightLeftRotation(AVLNode z) {
    var y = z.right;
    var x = y.left;
    var x_r = x.right;

    y.left = x_r;
    z.right = x;
    x_r = y;

    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(y.right)) + 1;

    return leftRotation(z);
  }

  private AVLNode minimo(AVLNode node) {
    if (node == null)
      return null;
    else if (node.left == null)
      return node;
    else
      return minimo(node.left);
  }

  private AVLNode maximo(AVLNode node) {
    if (node == null)
      return null;
    else if (node.right == null)
      return node;
    else
      return maximo(node.right);
  }

  private void inOrderPrint(AVLNode node) {
    if (node == null) {
      return;
    }
    inOrderPrint(node.left);
    System.out.println(node.data);
    inOrderPrint(node.right);
  }

}
