package com.sjani.java.LinkedList;

public class ReverseListTillK {

    public static Node reverse(Node head, int k){
        Node newHead = null;
        Node previous = null;
        Node next = null;
        int count = 0;
        previous = head;
        while(head.next!=null && count<k-1){
            next = head.next.next;
            head.next.next = previous;
            newHead = head.next;
            previous = head.next;
            head.next = next;
            count++;
        }
        if(next!=null) {
            head.next = reverse(next, k);
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Node head = null;
        head = linkedList.append(head,1);
        head = linkedList.append(head,2);
        head = linkedList.append(head,3);
        head = linkedList.append(head,4);
        head = linkedList.append(head,5);
        head = linkedList.append(head,6);
        head = linkedList.append(head,7);
        head = linkedList.append(head,8);
        linkedList.printList(head);
        head = reverse(head,3);
        linkedList.printList(head);
    }
}

