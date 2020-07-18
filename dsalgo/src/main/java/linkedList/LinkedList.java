package linkedList;

import java.util.Objects;

/* Node object for Linked List*/

public class LinkedList {

    Node head;


    public void addToTail(int value) {

        Node endNode = new Node(value);
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = endNode;

    }

    public void addToHead(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public Node deleteNode(int toBeDeleted) {

        Node prev;
        Node start = head;

        if (start.getValue() == toBeDeleted) {
            return start.next;
        }

        prev = start;

        while (start.next != null) {
            if (start.value == toBeDeleted) {
                prev.next = start.next;
                return head;
            }

            prev = start;
            start = start.next;
        }

        return head;
    }


    public void printList() {

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value);
            if(curr.next != null) {
                System.out.print("->");
            }
            curr = curr.next;
        }
    }


}

