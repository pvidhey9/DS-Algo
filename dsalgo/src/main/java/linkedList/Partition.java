package linkedList;

public class Partition {

    /* Partition a Linked List around a value k*/

    private static Node partitionAroundK(Node head, int k){

        Node beforePartitionHead = null;
        Node beforePartitionTail = null;
        Node afterPartitionHead = null;
        Node afterPartitionTail = null;

        Node curr = head;

        while(curr != null){
            Node present = new Node(curr.value);

            if(curr.value < k){
                if(beforePartitionHead == null){
                    beforePartitionHead = present;
                    beforePartitionTail = beforePartitionHead;
                } else {
                    beforePartitionTail.next = present;
                    beforePartitionTail = present;
                }
            } else {
                if(afterPartitionHead == null){
                    afterPartitionHead = present;
                    afterPartitionTail = afterPartitionHead;
                } else {
                    afterPartitionTail.next = present;
                    afterPartitionTail = present;
                }
            }

            curr = curr.next;
        }
        if(beforePartitionTail != null) {
            beforePartitionTail.next = afterPartitionHead;
            return beforePartitionHead;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.addToTail(2);
        head.addToTail(6);
        head.addToTail(4);
        head.addToTail(5);
        head.addToTail(3);
        head.addToTail(8);
        head.addToTail(1);

        Node result = partitionAroundK(head, 4);
        assert result != null;
        result.printList();
    }
}
