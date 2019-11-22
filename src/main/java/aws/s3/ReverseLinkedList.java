package aws.s3;

public class ReverseLinkedList {

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode r = reverseLinkedList.reverseLinkedList(l1);

        ListNode current = r;
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }

    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }


    public ListNode reverseLinkedList(ListNode head){

        ListNode prev = null; ListNode cur = head;

        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }

}
