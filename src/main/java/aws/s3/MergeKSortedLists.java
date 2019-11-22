package aws.s3;


import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * Use minHeap
 */
public class MergeKSortedLists {


    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    /**
     * Divide and Conqour
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(ListNode node: lists){
            while(node != null){
                minHeap.add(node.val);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode(-1);

        while(!minHeap.isEmpty()){
            dummy.next = new ListNode(minHeap.remove());
            dummy = dummy.next;
        }

        return dummy.next;

    }

}
