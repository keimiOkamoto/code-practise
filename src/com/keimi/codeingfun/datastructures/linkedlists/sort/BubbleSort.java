package com.keimi.codeingfun.datastructures.linkedlists.sort;

class Runener {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Node three = new Node(null, 3);
        Node seven = new Node(three, 7);
        Node two = new Node(seven, 2);
        Node head = new Node(two, 5);

        System.out.println(bubbleSort.bubbleSort(head));


    }
}




class BubbleSort {

    public Node calculate(Node node) {
        if (node.next != null) {
            bubbleSort(node);
            return calculate(node.next);
        }
        return node;
    }

    public Node bubbleSort(Node head) {
        if (head.next == null) {
            return head;
        } else {
            if (head.val > head.next.val) {
                Node aux = head.next;
                head.next = head.next.next;

                Node newHead = new Node(head, aux.val);
                head = newHead;
            }

            head = bubbleSort(head.next);
            System.out.println(head);

        }
        return head;

    }
}

class Node {
    Node next;
    int val;

    Node(Node next, int val) {
        this.next = next;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}



