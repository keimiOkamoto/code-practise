package com.keimi.codeingfun.datastructures.linkedlists.commonops;


class Runner {
    public static void main(String[] args) {
        Node root = new Node(new Node(new Node(new Node(null, 7), 5), 3), 1);
        SinglyLinkedListPractise listPractise = new SinglyLinkedListPractise();
        listPractise.print(root);
        System.out.println(listPractise.search(root, 9));
        listPractise.print(listPractise.append(root, 10));
        listPractise.print(listPractise.prepend(root, 10));
        System.out.print("Deleting from: \n");
        listPractise.print(root);
//        listPractise.print(listPractise.delete(root, 10));
        System.out.print("Inserting into... \n");
        listPractise.print(root);
        System.out.println();
        listPractise.print(listPractise.insertInOrder(root, 8));
        listPractise.print(listPractise.insertInOrder(root, 9));
        listPractise.print(root);
        listPractise.print(listPractise.delete(root, 5));
        System.out.println(listPractise.elementCount(root, 0));

        System.out.print("Bubble sorting \n");
        Node rootUnordered = new Node(new Node(new Node(new Node(null, 5), 7), 1), 3);
        listPractise.print(rootUnordered);
        Node node = listPractise.bubbleSort(rootUnordered);
        listPractise.print(node);


        String c = "H3Llo";
        String s = c.substring(0);
        System.out.println(s);

    }
}


class SinglyLinkedListPractise {

    void print(Node root) {
        if (root != null) {
            System.out.print(root.val + " -> ");
            print(root.next);
        } else {
            System.out.println();
        }
    }

    boolean search(Node root, int val) {
        if (root == null) {
            return false;
        } else {
            if (val == root.val) {
                return true;
            } else {
                return search(root.next, val);
            }
        }
    }

    Node insertInOrder(Node root, int val) {
        if (root == null) {
            return append(root.next, val);
        } else {
            if (val < root.val) {
                return prepend(root, val);
            } else {
                root.next = insertInOrder(root.next, val);
            }
        }
        return root;
    }

    Node delete(Node root, int val) {
        if (root == null) {
            return root;
        } else {
            if (root.val == val) {
                root = root.next;
                return root;
            } else {
                root.next = delete(root.next, val);
            }
        }
        return root;
    }

    Node append(Node root, int val) {
        if (root == null) {
            Node n = new Node(null, val);
            root = n;
            return root;
        } else {
            root.next = append(root.next, val);
        }
        return root;
    }


    Node prepend(Node root, int val) {
        Node n = new Node(null, val);
        n.next = root;

        return n;
    }

    Node bubbleSort(Node root) {
        int count = elementCount(root, 0);
        while (count != 0) {
            root = swapElements(root);
            count--;
        }
        return root;
    }

    Node swapElements(Node root) {
        if (root.next == null) {
            return root;
        } else {
            if (root.val > root.next.val) {
                Node temp = new Node(null, 0);
                temp = root;

                Node newRoot = new Node(root.next, root.next.val);
                root.next = root.next.next;
                newRoot.next = temp;

                return newRoot;
            }
            root.next = bubbleSort(root.next);

        }
        return root;
    }

    int elementCount(Node root, int count) {
        if (root == null) {
            return count;
        } else {
            count++;
            return elementCount(root.next, count);
        }
    }


    Node quickSort(Node root, int val) {
        if (root == null) {

        }
        return null;
    }

    Node mergeSort(Node root, int val) {
        if (root == null) {
            return root;
        } else {
        }
        return null;
    }

    Node radixSort(Node root, int val) {
        if (root == null) {

        }
        return null;
    }

    Node reverse(Node root, int val) {
        if (root == null) {

        }
        return null;
    }

    Node sortAccending(Node root, int val) {
        if (root.next == null) {

        }
        return null;
    }

    Node sortDeccending(Node root, int val) {
        if (root.next == null) {

        }
        return null;
    }
}

class Node {
    Node next;
    int val;

    public Node(Node next, int val) {
        this.next = next;
        this.val = val;
    }
}