import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        } 
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}

public class IsSubtree {
    public static TreeNode buildTree(Scanner sc) {
        System.out.println("Enter the root value (or -1 for null): ");
        int val = sc.nextInt();
        if (val == -1) {
            return null;
        }
        TreeNode root = new TreeNode(val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println("Enter the left child of " + node.val + " (or -1 for null): ");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                node.left = new TreeNode(leftVal);
                queue.add(node.left);
            }
            System.out.println("Enter the right child of " + node.val + " (or -1 for null): ");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                node.right = new TreeNode(rightVal);
                queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the main tree:");
        TreeNode root = buildTree(sc);

        System.out.println("Enter the subtree:");
        TreeNode subRoot = buildTree(sc);

        Solution solution = new Solution();
        boolean result = solution.isSubtree(root, subRoot);

        System.out.println("Is subRoot a subtree of root? " + result);

        sc.close();
    }
}
