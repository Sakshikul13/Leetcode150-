package DSA_Concepts;
import java.util.ArrayList;
public class binarysearchtree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    //Insert node in BST , RETURN TYPE NODE: recursively insert , returning the root node
    public static Node insert(Node root,int val){
        if(root==null){
            root= new Node(val);
            return root;
        }
        if(val<root.data){
            //left subtree
            root.left = insert(root.left, val);
        }
        else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data+"");
        inorder(root.right);
    }
    public static boolean BSTsearch(Node root, int key){
        if(root==null){
            return false;
        }
        if(key<root.data){
            return BSTsearch(root.left,key);
        }
        else if(key>root.data){
            return BSTsearch(root.right,key);
        }
        else{
            return true;
        }
    }
    //Deleting a node in BST(Single Question)
    public static Node delete(Node root,int val){
        //first search for the node that needs to be deleted
        if(val<root.data){
            root.left= delete(root.left, val);
        }
        else if(val>root.data){
            root.right=delete(root.right,val);
        }
        else { //reached the node that we want to delete
            //case 1: No child
            if(root.left==null && root.right ==null){
                return null;
            }
            //case 2: one child right child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            //case 3: Both childs
            Node IS=inorderSuccessor(root.right);
            root.data=IS.data; //replace
            root.right=delete(root.right, IS.data);   //No duplicates allowed also this node is now the node that is deleted 
        }
        return root;

    }
    public static Node inorderSuccessor(Node root){  //leftmost value
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printInRange(Node root,int X,int Y){
        if(root==null){
            return;
        }
        if(root.data>= X && root.data<=Y){
            printInRange(root.left, X, Y);
            System.out.print(root.data+" ");
            printInRange(root.right, X, Y);
        }
        else if(root.data >=Y){
            printInRange(root.left, X, Y);
        }
        else{
            printInRange(root.right, X, Y);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
    public static void rootToLeafPaths(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        //leaf
        if(root.left==null && root.right == null){
            printPath(path);
        }else{
            rootToLeafPaths(root.left, path);
            rootToLeafPaths(root.right, path);
        }
        path.remove(path.size()-1);
    }
    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root= null;
        for(int i=0;i<values.length;i++){
            root= insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        if(BSTsearch(root,1)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found")
        }
        delete(root, 4);
        inorder(root);
        delete(root, 10);
        inorder(root);
        delete(root,5);
        inorder(root);
        printInRange(root, 6, 10);
        rootToLeafPaths(root, new ArrayList<>());
    }
}
