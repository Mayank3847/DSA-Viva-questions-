class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Binary_tree_Mirror_Of_Tree {
    Node root;

    void mirror() {
        root = mirror(root);
    }

    Node mirror(Node node) {
        if (node == null)
            return node;

        Node leftA = mirror(node.left);
        Node rightA = mirror(node.right);

        node.left = rightA;
        node.right = leftA;

        return node;
    }

    void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);

        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String args[]) {
        Binary_tree_Mirror_Of_Tree tree = new Binary_tree_Mirror_Of_Tree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Inorder traversal of the original tree:");
        tree.inOrder(tree.root);
        System.out.println(); 

        tree.mirror();

        System.out.println("Inorder traversal of the mirrored tree:");
        tree.inOrder(tree.root);
        
    }
}
