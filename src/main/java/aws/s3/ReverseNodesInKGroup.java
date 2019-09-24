package aws.s3;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup {

    private ListNode resultNode;

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public void addToLinkedList(int val){
        ListNode newNode = new ListNode(val);

        if(resultNode == null){
            resultNode = newNode;
        }else {
            ListNode last = resultNode;
            while(last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    }


    public ListNode reverseKGroup(ListNode head, int k) {

        List<int[]> list = new ArrayList<>();
        ListNode current = head;
        int count = 0;
        int[] array = new int[k];

        while(current != null){
            array[count++] = current.val;
            current = current.next;
            if(count == k){
                list.add(array);
                array = new int[k];
                count = 0;
            }
        }
        List<int[]> reversed = new ArrayList<>();
        for(int[] a : list){
            reversed.add(reverseArray(a));
        }

        for(int[] aa: reversed){
            for(int i=0; i<aa.length; i++){
                addToLinkedList(aa[i]);
            }
        }
        for(int i=0; i< count; i++){
            addToLinkedList(array[i]);
        }
        return resultNode;
    }


    private int[] reverseArray(int[] a){
        int[] reversed = new int[a.length];
        int i=0;
        while(i < a.length){
            reversed[i] = a[a.length-1-i++];
        }
        return reversed;
    }


    public static void main(String[] args){
        int[] a = new int[]{2,4,6};
        ReverseNodesInKGroup sl = new ReverseNodesInKGroup();

        int[] b = sl.reverseArray(a);
        System.out.println(b);


        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode result = sl.reverseKGroup(one, 3);
        System.out.println(result.toString());

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }

}
