package com.sjani.java.LinkedList;

public class DoublyLinkedList<T extends Comparable<T>> {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Node head = null;
        head = doublyLinkedList.append(head, 18);
        head = doublyLinkedList.append(head, 45);
        head = doublyLinkedList.append(head, 12);
        doublyLinkedList.printList(head);
        head = doublyLinkedList.prepend(head, 14);
        head = doublyLinkedList.append(head, 34);
        doublyLinkedList.printList(head);
        head = doublyLinkedList.insert(head, 5, 3);
        doublyLinkedList.printList(head);
        head = doublyLinkedList.insert(head, 55, 5);
        doublyLinkedList.printList(head);
        head = doublyLinkedList.insert(head, 61, 7);
        doublyLinkedList.printList(head);
        head = doublyLinkedList.insert(head, 76, 0);
        doublyLinkedList.printList(head);
        head = doublyLinkedList.deleteAtPosition(head, 3);
        doublyLinkedList.printList(head);
        head = doublyLinkedList.deleteAtPosition(head, 7);
        doublyLinkedList.printList(head);
        head = doublyLinkedList.deleteWithData(head, 55);
        doublyLinkedList.printList(head);
        head = doublyLinkedList.reverseIterative(head);
        doublyLinkedList.printList(head);
        head = doublyLinkedList.reverseRecursive(head);
        doublyLinkedList.printList(head);
    }

    public Node prepend(Node head, T data) {
        Node node = new Node(data);
        if (head == null) {
            return node;
        }
        node.next = head;
        head.previous = node;
        return node;
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
        node.previous = current;
        return temp;
    }

    public Node insert(Node head, T data, int position) {
        Node temp = head;
        Node node = new Node(data);
        if (head == null) {
            return node;
        }
        if (position == 0) {
            node.next = head;
            head.previous = node;
            return node;
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
        if (current.next != null) {
            current.next.previous = node;
        }
        current.next = node;
        node.previous = current;
        return temp;
    }

    public Node deleteAtPosition(Node head, int position) {
        Node temp = head;
        if (head == null) {
            return null;
        }
        if (position == 0) {
            head = head.next;
            head.previous = null;
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
        if (current.next != null) {
            current.next.previous = current;
        }
        return temp;
    }

    public Node deleteWithData(Node head, int data) {
        Node temp = head;
        if (head == null) {
            return null;
        }
        if (head.data.compareTo(data) == 0) {
            head = head.next;
            head.previous = null;
            return head;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.compareTo(data) == 0) {
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.previous = current;
                }
                return temp;
            }
            current = current.next;
        }
        return temp;
    }

    public Node reverseIterative(Node head) {
        Node current = head;
        Node previous = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = current.previous;
            current.previous = next;
            previous = current;
            current = next;
        }
        return previous;
    }


    public Node reverseRecursive(Node head) {
        Node current = head;
        Node next;
        if (current.next == null) {
            head = current;
            return head;
        }
        head = reverseRecursive(current.next);
        next = current.next;
        current.next = current.previous;
        current.previous = next;
        current.previous.next = current;
        current.next = null;
        return head;
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

}
