package com.keimi.codeingfun.datastructures.trees;

import java.util.List;

class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode n3 = new TreeNode(3);
        TreeNode n10 = new TreeNode(10);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n14 = new TreeNode(14);
        TreeNode n13 = new TreeNode(13);

        root.left = n3;
        root.right = n10;

        n10.right = n14;
        n14.left = n13;

        n3.left = n1;
        n3.right = n6;

        n6.left = n4;
        n6.right = n7;

        System.out.println();

        TreeProblems treeProblems = new TreeProblems();
//        TreeNode insert = treeProblems.insert(root, 12);
//        TreeNode treeNode = treeProblems.delete1(root, 7);
        treeProblems.traversPreOrder(root);
//        TreeNode treeNode = treeProblems.delete1(root, 7);
        TreeNode insert = treeProblems.insert(root, 2);
        System.out.println();
        treeProblems.traversPreOrder(insert);
        System.out.println();


//        TreeNode tree = treeProblems.createTree(new TreeNode(0), Arrays.asList(1, 2, 3, 4, 8, 7, 13, 14, 12));
//        treeProblems.traversPreOrder(tree);

//        System.out.println(tree);
    }
}

class TreeProblems {

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            TreeNode treeNode = new TreeNode(val);
            root = treeNode;
            return root;
        } else {
            if (val < root.val) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
        }
        return root;
    }

    public TreeNode delete(TreeNode treeNode, int val) {
        return null;
    }

    public TreeNode createTree(TreeNode root, List<Integer> numbers) {
        if (numbers.isEmpty() || root == null) {
            return root;
        } else {
            if (numbers.get(0) < root.val) {
                TreeNode node = new TreeNode(numbers.get(0));
                root.left = node;
                root.left = createTree(root.left, numbers.subList(1, numbers.size()));
            } else {
                TreeNode node = new TreeNode(numbers.get(0));
                root.right = node;
                root.right = createTree(root.right, numbers.subList(1, numbers.size()));
            }
        }
        return root;
    }

    public TreeNode traversInOrder(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            traversPreOrder(root.left);
            System.out.print(root.val + " ");
            traversPreOrder(root.right);
        }
        return root;
    }

    public TreeNode traversPreOrder(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            System.out.print(root.val + " ");
            traversPreOrder(root.left);
            traversPreOrder(root.right);
        }
        return root;
    }

    public TreeNode traversPostOrder(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            traversPreOrder(root.left);
            traversPreOrder(root.right);
            System.out.print(root.val + " ");
        }
        return root;
    }


    public TreeNode delete1(TreeNode node, int val) {
        if (node == null) {
            return null;
        } else if (val < node.val) {
            node.left = delete1(node.left, val);
        } else if (val > node.val) {
            node.right = delete1(node.right, val);
        } else { //found
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else { //two children are present
                TreeNode n = findMinimumValue(node.right, node.right.val);
                node.val = n.val;
                node.right = delete(node.right, node.val);
            }
        }
        return node;
    }

    private TreeNode findMinimumValue(TreeNode node, int min) {
        if (node == null) {
            return node;
        } else {
            if (node.val < min) {
                min = node.val;
            }
            findMinimumValue(node, min);
        }
        return node;
    }
}

class PruneToRange {


    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root != null) {
            if (!(root.val <= L && root.val <= R)) {
                removeNode(root);
                if (root.right != null) {
                    root = insert(root.right, root);
                }
            }
            trimBST(root.left, L, R);
            trimBST(root.right, L, R);

        }
        return root;
    }

    private TreeNode removeNode(TreeNode root) {
//        root
        return null;
    }

    private TreeNode insert(TreeNode node, TreeNode root) {
        if (root != null) {
            if (node.val > root.val) {
                node.right = insert(node, root.right);
            } else {
                node.left = insert(node, root.right);
            }
        } else {
            root = node;
            return root;
        }
        return root;
    }

}
