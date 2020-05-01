package leetcode.random;

public class ReverseListInKGroup {

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(8);

        l1.next = l2;
        l2.next = l3;

        ReverseListInKGroup reverseLinkedList = new ReverseListInKGroup();
        ReverseListInKGroup.ListNode r = reverseLinkedList.reverseKGroup(l1, 2);

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode start = head;
        ListNode last = null;
        int count = 0;

        if(head == null) return null;

        while(cur != null){
            if(count == k){
                ListNode reversed = reverse(start);
                ListNode l = reversed;
                while(l.next != null){
                    l = l.next;
                }
                l.next = reverseKGroup(cur.next, k);
                cur = cur.next;
                count = 0;
            }else {
                count++;
                cur = cur.next;
            }
        }
        return start;
    }

    ListNode reverse(ListNode head){
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
