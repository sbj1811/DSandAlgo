package com.sjani.java.LinkedList;

public class LinkedList {

    Node head;

    public void prepend(int data){
        Node node =  new Node(data);
        node.next = head;
        head = node;
    }

    public void append(int data){
        Node node =  new Node(data);
        if(head == null){
            head = node;
            return;
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
    }

    public void insert(int data, int position){
        Node node =  new Node(data);
        if(head == null){
            head = node;
            return;
        }
        if(position ==  0){
            node.next =  head;
            head = node;
            return;
        }
        Node current = head;
        Node previous = null;
        int i = 0;
        while(i < position-1){
            previous =  current;
            current =  current.next;
            if(current.next == null){
                break;
            }
            i++;
        }
        node.next = current.next;
        current.next = node;
    }

    public void deleteAtPosition(int position){
        if(head ==  null){
            return;
        }
        if(position == 0){
            head = head.next;
            return;
        }
        Node current = head;
        int i = 0;
        while (i < position-1){
            current = current.next;
            if(current.next == null){
                break;
            }
            i++;
        }
        current.next = current.next.next;
    }

    public void deleteWithData(int data){
        if(head ==  null){
            return;
        }
        if(head.data == data){
            head = head.next;
            return;
        }
        Node current =  head;
        while (current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current =  current.next;
        }
    }

    public int size(){
        if(head == null){
            return 0;
        }
        int i = 0;
        Node current = head;
        while(current != null){
            i++;
            current = current.next;
        }
        return i;
    }


    public void printList(){
        if(head == null){
            System.out.println("List is null");
            return;
        }
        Node current = head;
        while(current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.print("  |  Size: "+this.size());
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(18);
        linkedList.append(45);
        linkedList.append(12);
        linkedList.printList();
        linkedList.prepend(14);
        linkedList.append(34);
        linkedList.printList();
        linkedList.insert(5,3);
        linkedList.printList();
        linkedList.insert(55,5);
        linkedList.printList();
        linkedList.insert(61,7);
        linkedList.printList();
        linkedList.insert(76,0);
        linkedList.printList();
        linkedList.deleteAtPosition(3);
        linkedList.printList();
        linkedList.deleteAtPosition(7);
        linkedList.printList();
        linkedList.deleteWithData(55);
        linkedList.printList();
    }
}