package leetcode30Challenge;

import leetcode.AddTwoNumbers;

import java.util.List;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 *
 * Note:
 *
 * The number of nodes in the given list will be between 1 and 100.
 */
public class MiddleLinkedList {

    public ListNode middleNode(ListNode head) {
        if(head == null) throw new RuntimeException();

        int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            if(length > 100) throw new RuntimeException();
            current = current.next;
        }
        int mid = length/2;
        int currentPosition = 0;
        ListNode result = null;
        while(head != null){
            if(currentPosition >= mid){
                result = addNode(result, new ListNode(head.val));
            }
            currentPosition++;
            head = head.next;
        }

        return result;
    }

    public ListNode addNode(ListNode result, ListNode node){
        node.next = null;
        if(result == null) {
            result = node;
        }else {
            ListNode current = result;
            while(current.next != null){ // point at the last element
                current = current.next;
            }
            current.next = node;
        }
        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        MiddleLinkedList middleLinkedList = new MiddleLinkedList();
        ListNode listNode = middleLinkedList.middleNode(l1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
