public class Binary_tree_preorder {
    static class Node {
        int data;
        Node left_subtree;
        Node right_subtree;

        Node(int data) {
            this.data = data;
            this.left_subtree = null;
            this.right_subtree = null;

        }
    }

    static class BinaryTree {
        static int index = -1;

        public Node buildTree(int nodes[]) {
            index++;
            if (index >= nodes.length || nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left_subtree = buildTree(nodes);
            newNode.right_subtree = buildTree(nodes);
            return newNode;
        }

        public  void   preOrder(Node root) {
            if (root == null) {
                return ;

            }
            System.out.print(root.data + " ");
            preOrder(root.left_subtree);
            preOrder(root.right_subtree);
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("PREORDER TRAVERSAL");
        tree.preOrder(root);
    }
}
