class Node {
    int data;
    Node parent, left, right;
    boolean color; 

    public Node(int data) {
        this.data = data;
        this.color = true; 
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class RedBlackTree {
    private final Node NIL;
    private Node root;

    public RedBlackTree() {
        NIL = new Node(-1);
        NIL.color = false; 
        root = NIL;
    }

    public void insert(int key) {
        Node node = new Node(key);
        node.left = NIL;
        node.right = NIL;

        Node parent = null;
        Node current = root;

        while (current != NIL) {
            parent = current;
            if (node.data < current.data)
                current = current.left;
            else
                current = current.right;
        }

        node.parent = parent;

        if (parent == null)
            root = node;
        else if (node.data < parent.data)
            parent.left = node;
        else
            parent.right = node;

        node.color = true; // RED
        fixInsert(node);
    }

    private void fixInsert(Node z) {
        while (z.parent != null && z.parent.color) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right; // uncle
                if (y != null && y.color) {
                    // Case 1
                    z.parent.color = false;
                    y.color = false;
                    z.parent.parent.color = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        // Case 2
                        z = z.parent;
                        leftRotate(z);
                    }
                    // Case 3
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    rightRotate(z.parent.parent);
                }
            } else {
                // Mirror case
                Node y = z.parent.parent.left;
                if (y != null && y.color) {
                    z.parent.color = false;
                    y.color = false;
                    z.parent.parent.color = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = false;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL)
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != NIL)
            y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;
        y.right = x;
        x.parent = y;
    }

    public void inorderTraversal() {
        System.out.print("Inorder: ");
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(Node node) {
        if (node != NIL) {
            inorderHelper(node.left);
            System.out.print(node.data + (node.color ? "(R) " : "(B) "));
            inorderHelper(node.right);
        }
    }
}

public class RedBlackTreeInsertion {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        int[] values = {10, 20, 30, 15, 25, 5, 1};

        for (int val : values) {
            rbt.insert(val);
            rbt.inorderTraversal();
        }
    }
}
