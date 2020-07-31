package linkedList;

public class ReturnKthToLast {

    /* Find kth to last element of singly linked list */

    private static Node returnKthToLast(Node linkedList, int k){

        int length = linkedList.length();
        int kthToFront = length - k + 1;

        if(k == 0){
            return null;
        }
        if(kthToFront < 0 ){
            return null;
        }

        Node curr = linkedList;
        int currIndex = 0;
        while(curr != null){
            currIndex = currIndex + 1;
            if(currIndex == kthToFront){
                return curr;
            }

            curr = curr.next;
        }

        return null;
    }

    private static Node returnKthToLastUsingTwoPointers(Node head, int k){

        Node ptr1 = head;
        Node ptr2 = head;

        for(int i = 0; i< k ; i++){
            if(ptr1 == null){
                return null;
            }
            ptr1 = ptr1.next;
        }

        while(ptr1 != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

        }

        return ptr2;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.addToTail(2);
        head.addToTail(3);
        head.addToTail(4);
        head.addToTail(5);
        head.addToTail(6);

        System.out.println(returnKthToLast(head, 2));
        System.out.println(returnKthToLastUsingTwoPointers(head, 2));
    }


}
