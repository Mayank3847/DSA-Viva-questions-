public class BST_Delete {
    static class Node {
        int data;
        Node leftSubtree;
        Node rightSubtree;

        public Node(int data) {
            this.data = data;
            this.leftSubtree = null;
            this.rightSubtree = null;
        }
    }

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.rightSubtree = delete(root.rightSubtree, val);

        } else if (root.data > val) {
            root.leftSubtree = delete(root.leftSubtree, val);
        } else {
            // case 1---No child node
            if (root.leftSubtree == null && root.rightSubtree == null) {
                return null;
            }
            // case 2--One child node
            if (root.leftSubtree == null) {
                return root.rightSubtree;
            } else if (root.rightSubtree == null) {
                return root.leftSubtree;
            }
            // case 3--two child
            Node IS = findInorderSuccessor(root.rightSubtree);
            root.data = IS.data;
            root.rightSubtree = delete(root.rightSubtree, IS.data);

        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.leftSubtree != null) {
            root = root.leftSubtree;
        }
        return root;
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;

        }
        if (root.data > val) {
            root.leftSubtree = insert(root.leftSubtree, val);
        } else {
            root.rightSubtree = insert(root.rightSubtree, val);
        }
        return root;
    }

    public static void Inorder(Node root) {

        if (root == null) {
            return;
        }
        Inorder(root.leftSubtree);
        System.out.print(root.data + " ");
        Inorder(root.rightSubtree);
    }

    public static void main(String[] args) {
        int value[] = { 8,5,3,1,4,6,10,11,14 };
        Node root = null;
        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
        Inorder(root);
        System.out.println();
        root = delete(root, 1);
        System.out.println();
        Inorder(root);

    }

}
