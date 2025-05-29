// import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class Binary_tree_LevelOrder {
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

        public void levelOrder(Node root) {
            if (root == null) {
                return;

            }
            Queue<Node> qu = new LinkedList<>();
            qu.add(root);
            qu.add(null);
            while (!qu.isEmpty()) {
                Node currNode = qu.remove();
                if (currNode == null) {
                    System.out.println();
                    if (qu.isEmpty()) {
                        break;
                    } else {
                        qu.add(null);

                    }

                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left_subtree != null) {
                        qu.add(currNode.left_subtree);
                    }
                    if (currNode.right_subtree != null) {
                        qu.add(currNode.right_subtree);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("PREORDER TRAVERSAL");
        tree.levelOrder(root);
    }
}
