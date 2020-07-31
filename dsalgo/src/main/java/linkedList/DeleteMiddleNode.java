package linkedList;

public class DeleteMiddleNode {

    /* Delete middle node */


    private static void deleteMiddleNode(Node middleNode){

        if(middleNode == null || middleNode.next == null){
            return;
        }

        Node nextOfMiddleNode = middleNode.next;
        middleNode.value = nextOfMiddleNode.value;
        middleNode.next = nextOfMiddleNode.next;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.addToTail(2);
        head.addToTail(3);
        head.addToTail(4);
        head.addToTail(5);
        head.addToTail(6);
        head.printList();

        System.out.println("");
        deleteMiddleNode(head.next.next);
        head.printList();



    }
}
