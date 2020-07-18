package linkedList;

import java.util.HashSet;

public class RemoveDuplicates {

    /* Remove duplicates from unsorted linked list

       Eg.,
       Input : 1 -> 2 -> 5 -> 3 -> 2 -> 4 -> 3
       Output : 1 -> 2 -> 5 -> 3 -> 4

    */

    private static void removeDuplicates(LinkedList list){

        HashSet<Node> visitedNodes = new HashSet<>();

        Node start = list.head;
        Node prev = list.head;

        while(start != null){
            if(visitedNodes.contains(start)){
                prev.next = start.next;
            } else {
                visitedNodes.add(start);
                prev = start;
            }


            start = start.next;

        }

    }

    /* Time complexity : O(n^2) */
    private static void removeDuplicatesWithoutSpace(Node head){

        Node current = head;

        while( current != null ){

            Node perCurrentPointer = current;

            while(perCurrentPointer.next != null){

                if(perCurrentPointer.next.value == current.value){
                    perCurrentPointer.next = perCurrentPointer.next.next;
                } else {
                    perCurrentPointer = perCurrentPointer.next;
                }
            }

            current = current.next;
        }
    }


    public static void main(String[] args) {

        LinkedList inputList = new LinkedList();
        inputList.addToHead(1);
        inputList.addToHead(2);
        inputList.addToHead(3);
        inputList.addToHead(3);
        inputList.addToHead(4);
        inputList.printList();

        System.out.println();
        System.out.println("************");
        removeDuplicates(inputList);
        inputList.printList();


        Node head = new Node(1);
        head.addToTail(2);
        head.addToTail(3);
        head.addToTail(3);
        head.addToTail(4);
        head.addToTail(4);
        head.printList();

        System.out.println();
        System.out.println("********");
        removeDuplicatesWithoutSpace(head);
        head.printList();
    }
}
