package com.keimi.codeingfun.datastructures.trees;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Solution3 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(7);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);
        TreeNode treeNode = searchBST(t1, 5);
        System.out.println(treeNode);
    }

     public static TreeNode searchBST(TreeNode root, int val) {
         if (root == null || root.left == null || root.right == null ) {
             return null;
         } else {
             if (root.left.val == val) {
                 root = root.left;
                 return root;
             } else if (root.right.val == val) {
                 root = root.right;
                 return root;
             } else {
                 searchBST(root.left, val);
                 searchBST(root.right, val);
                 return null;
             }
         }
     }
}