package linkedList;

import java.util.Objects;

public class Node {

    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getValue() == node.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


    void addToTail(int value) {

        Node endNode = new Node(value);
        Node currNode = this;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = endNode;

    }

    public Node addToHead(int value) {
        Node head = this;
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }

    void printList() {

        Node curr = this;
        while (curr != null) {
            System.out.print(curr.value);
            if(curr.next != null) {
                System.out.print("->");
            }
            curr = curr.next;
        }
    }

}
