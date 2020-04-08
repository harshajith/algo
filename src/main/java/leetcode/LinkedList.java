package leetcode;

public class LinkedList<N> {

    Node head;

    static class Node{
        int value;
        Node next;
        Node previous;

        public Node(int value){
            this.value = value;
            next = null;
            previous = null;
        }
    }

    /**
     * Insert at the end of the list
     * @param val
     */
    public void insertNode(int val){
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
        }else {
            Node last = head;
            while(last.next != null){
                last = last.next; // get to the last element of the linkedList
            }
            newNode.previous = last;
            last.next = newNode;

        }
    }


    public void removeNode(int val){
        if(head == null){
            throw new RuntimeException("list is empty");
        }
        Node candidate = head;
        while(candidate != null){
            if(val == candidate.value){
                candidate.previous.next = candidate.next;
                break;
            }else {
                candidate = candidate.next;
            }
        }
    }

    private void printList(){
        while(head != null){
            System.out.println("Val: " + head.value);
            head = head.next;
        }
    }

    public static void main(String[] args){
        LinkedList<Node> list = new LinkedList<Node>();
        list.insertNode(3);
        list.insertNode(1);
        list.insertNode(6);
        list.insertNode(7);
        list.insertNode(8);
        list.insertNode(5);
        list.insertNode(3);
        list.insertNode(9);

        //list.removeNode(7);

        list.printList();
    }



}
