public class BST_MirrorOfBST {
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
    public static Node createMirror(Node root){
        if(root==null){
            return null;
        }
        Node leftMirror=createMirror(root.leftSubtree);
        Node rightMirror=createMirror(root.rightSubtree);
        root.leftSubtree=rightMirror;
        root.rightSubtree=leftMirror;
        return root;
    }
    public static void Preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        Preorder(root.leftSubtree);
        Preorder(root.rightSubtree);

    }
    public static void main(String[] args) {
        Node root=new Node(8);
        root.leftSubtree=new Node(5);
        root.rightSubtree=new Node(10);
        root.leftSubtree.leftSubtree=new Node(3);
        root.leftSubtree.rightSubtree=new Node(6);
        root.rightSubtree.rightSubtree=new Node(11);
        root.rightSubtree.leftSubtree=new Node(7);

root=createMirror(root);
Preorder(root);

    }
    
}
