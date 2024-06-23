package DSA_Concepts;
import java.util.*;
public class binarytree {
    static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }   
    
    static class BinaryTree {
        static int idx = -1; // so that we can increment it to the length of the array.
        
        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;  // -1 is null node, directly return null
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    public static void preorder(Node root){
        //print root, left subtree, right subtree
        if(root==null){
            System.out.print(-1+" ");
            return; 
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        //print left subtree, root, right subtree
        if(root==null){
            System.out.print(-1+" ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
        
    }
    public static void postorder(Node root){
        //left subtree, right subtree, root
        if(root==null){
            System.out.print(-1+" ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
        
    }
    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){ //until queue is empty
            Node currNode=q.remove();     //remove the current node and add in the queues based on conditions.
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){    //if null was the last node in the queue
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }

    }

    public static int countOfNodes(Node root){
        //recursion
        if(root==null){ //base case
            return 0;
        }
        int leftNodes=countOfNodes(root.left);
        int rightNodes=countOfNodes(root.right);
        return leftNodes+rightNodes+1;
    }
    public static int sumOfNodes(Node root){
        //recursion
        if(root==null){
            return 0;
        }
        int leftSum=sumOfNodes(root.left);
        int rightSum=sumOfNodes(root.right);
        return leftSum+rightSum+root.data;
    }
    public static int heightOfTree(Node root){
        //base case 
        if(root==null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int myHeight=Math.max(leftHeight,rightHeight)+1;
        return myHeight;
    }
    public static int diameterOfTree(Node root){
        if(root==null){
            return 0;
        }
        //Number of Nodes in the longest path between any 2 nodes
        int diam1=diameterOfTree(root.left);
        int diam2=diameterOfTree(root.right);
        int diam3=heightOfTree(root.left)+heightOfTree(root.right)+1;

        return Math.max(diam3,Math.max(diam1,diam2));
         
    }
    static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }

    public static TreeInfo diameterOfTree2(Node root){  //cannot return two values so created a class
        if(root==null){
            return new TreeInfo(0, 0);
        }
        TreeInfo left= diameterOfTree2(root.left);
        TreeInfo right=diameterOfTree2(root.right);
        int myHeight = Math.max(left.ht,right.ht)+1;
        int diam1=left.diam;
        int diam2=right.diam;
        int diam3=left.ht+right.ht+1;
        int mydiam=Math.max(Math.max(diam1,diam2),diam3);
        TreeInfo myInfo=new TreeInfo(myHeight, mydiam);
        return myInfo;
    }
     
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("The root node is:");
        System.out.println(root.data);
        System.out.println("Preorder Traversal:");
        preorder(root);
        System.out.println();
        System.out.println("Inorder Traversal:");
        inorder(root);
        System.out.println();
        System.out.println("Postorder Traversal:");
        postorder(root);
        System.out.println();
        System.out.println("levelOrder Traversal:");
        levelOrder(root);
        System.out.println();
        System.out.println("Count of Nodes:");
        System.out.println(countOfNodes(root));
        System.out.println("Sum of Nodes:");
        System.out.println(sumOfNodes(root));
        System.out.println("Height of Tree:");
        System.out.println(heightOfTree(root));
        System.out.println("Diameter of Tree (O(N2)):");
        System.out.println(diameterOfTree(root));
        System.out.println("Diameter of Tree (O(N)):");
        System.out.println(diameterOfTree2(root).diam); 

    }
}
