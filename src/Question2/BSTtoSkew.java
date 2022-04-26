package Question2;

public class BSTtoSkew {
    Node root;
    static Node newroot,curr;
    public static class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public void inorderTraversal(Node root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data +" ");
        inorderTraversal(root.right);
    }
    public void bsttoSkew( Node root){
        if(root==null){
            return ;
        }
        bsttoSkew(root.left);

        if(curr==null){
            curr =root;
            newroot = root;
        }
        else{
            curr.right=root;
            curr.left=null;
            curr=curr.right;
        }
        bsttoSkew(root.right);
    }
    public static void main(String[] args) {
        BSTtoSkew tree = new BSTtoSkew();
        tree.root =new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(60);
        tree.root.left.left = new Node(10);
        //tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(55);
        System.out.println("Inorder traversal for given tree:");
        tree.inorderTraversal(tree.root);
        curr=null;
        tree.bsttoSkew(tree.root);
        tree.root = newroot;
        System.out.println("");
        System.out.println("Skewed Tree:");
        while(newroot!=null){
            System.out.print(newroot.data+" ");
            newroot=newroot.right;
        }
    }
}
