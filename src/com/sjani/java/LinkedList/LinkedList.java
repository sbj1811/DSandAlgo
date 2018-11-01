package com.sjani.java.LinkedList;

public class LinkedList<T extends Comparable<T>> {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Node head = null;
        head = linkedList.append(head,18);
        head = linkedList.append(head,45);
        head = linkedList.append(head,12);
        linkedList.printList(head);
        head = linkedList.prepend(head,14);
        head = linkedList.append(head,34);
        linkedList.printList(head);
        head = linkedList.insert(head,5, 3);
        linkedList.printList(head);
        head = linkedList.insert(head,55, 5);
        linkedList.printList(head);
        head = linkedList.insert(head,61, 7);
        linkedList.printList(head);
        head = linkedList.insert(head,76, 0);
        linkedList.printList(head);
        linkedList.printListRecursive(head);
        System.out.println();
        linkedList.printReverseRecursive(head);
        System.out.println();
        head = linkedList.deleteAtPosition(head,3);
        linkedList.printList(head);
        head = linkedList.deleteAtPosition(head,7);
        linkedList.printList(head);
        head = linkedList.deleteWithData(head,55);
        linkedList.printList(head);
        head = linkedList.reverseIterative(head);
        linkedList.printList(head);
        head = linkedList.reverseRecursive(head);
        linkedList.printList(head);
    }

    public Node prepend(Node head, T data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }

    public Node append(Node head, T data) {
        Node temp = head;
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return head;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        return temp;
    }

    public Node insert(Node head, T data, int position) {
        Node temp = head;
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return head;
        }
        if (position == 0) {
            node.next = head;
            head = node;
            return head;
        }
        Node current = head;
        int i = 0;
        while (i < position - 1) {
            current = current.next;
            if (current.next == null) {
                break;
            }
            i++;
        }
        node.next = current.next;
        current.next = node;
        return temp;
    }

    public Node deleteAtPosition(Node head, int position) {
        Node temp = head;
        if (head == null) {
            return null;
        }
        if (position == 0) {
            head = head.next;
            return head;
        }
        Node current = head;
        int i = 0;
        while (i < position - 1) {
            current = current.next;
            if (current.next == null) {
                break;
            }
            i++;
        }
        current.next = current.next.next;
        return temp;
    }

    public Node deleteWithData(Node head, T data) {
        Node temp = head;
        if (head == null) {
            return null;
        }
        if (head.data == data) {
            head = head.next;
            return head;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.compareTo(data) == 0) {
                current.next = current.next.next;
                return temp;
            }
            current = current.next;
        }
        return temp;
    }

    public int size(Node head) {
        if (head == null) {
            return 0;
        }
        int i = 0;
        Node current = head;
        while (current != null) {
            i++;
            current = current.next;
        }
        return i;
    }

    public void printList(Node head) {
        if (head == null) {
            System.out.println("List is null");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print("  |  Size: " + this.size(head));
        System.out.println();
    }

    public void printListRecursive(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        printListRecursive(head.next);
    }

    public void printReverseRecursive(Node head) {
        if (head == null) {
            return;
        }
        printReverseRecursive(head.next);
        System.out.print(head.data + " ");
    }


    public Node reverseIterative(Node head) {
        Node current = head;
        Node previous = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    public Node reverseRecursive(Node head) {
        Node current = head;
        if(current.next == null){
            head = current;
            return head;
        }
        Node newPrevious;
        head = reverseRecursive(current.next);
        newPrevious =  current.next;
        newPrevious.next =  current;
        current.next = null;
        return head;
    }
}