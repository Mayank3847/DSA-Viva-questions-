/**
 * BST_LargestBSTSize
 */
public class BST_LargestBSTSize {
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

    static class Info {
        boolean isBST;
        int size;
        int min, max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxSize = 0;

public static Info largestBST(Node root){
    if(root==null){
        return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    Info leftInfo= largestBST(root.leftSubtree);
    Info rightInfo= largestBST(root.rightSubtree);
    int size=leftInfo.size+rightInfo.size+1;
    int min=Math.min(root.data, Math.min(leftInfo.min,rightInfo.min));
    int max=Math.min(root.data, Math.max(leftInfo.max,rightInfo.max));
    if(root.data<=leftInfo.max || root.data>=rightInfo.min){
        return new Info(false, size, min, max);
    }
    if(leftInfo.isBST&&rightInfo.isBST){
         maxSize=Math.max(maxSize,size);
         return new Info(true, size, min, max);
    }
    return new Info(false, size, min, max);

}
public static void main(String[] args) {
    Node root=new Node(50);
    root.leftSubtree=new Node(30);
    root.rightSubtree=new Node(60);
    root.leftSubtree.leftSubtree=new Node(5);
    root.rightSubtree.leftSubtree=new Node(45);

    root.leftSubtree.rightSubtree=new Node(20);
    root.rightSubtree.rightSubtree=new Node(70);
    root.rightSubtree.rightSubtree.leftSubtree=new Node(65);
    root.rightSubtree.rightSubtree.rightSubtree=new Node(80);
    Info info=largestBST(root);
    System.out.println(info);
    System.out.println("Largest BST " +maxSize);

}

}