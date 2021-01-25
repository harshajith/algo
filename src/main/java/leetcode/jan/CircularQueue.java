package leetcode.jan;

/**
 * Implement CircularQueue using an Array
 */
public class CircularQueue {

    int size = 0;
    int[] array;
    int head;
    int tail;
    public CircularQueue(int size){
        this.size = size;
        this.array = new int[size];
        this.head = -1;
        this.tail = -1;
    }

    public void enqueue(int val){
        if(!isFull()){
            tail = (tail + 1) % size;
            array[tail] = val;
            if(head == -1){
                head = 0;
            }
        }else {
            throw new CircularQueueException("Queue is full");
        }
    }

    public int dequeue(){
        int val;
        if(!isEmpty()){
            val = array[head];
            if(head == tail){ //if only one element present in the array, reset pointers
                head = -1;
                tail = -1;
            }else {
                head = (head + 1) % size; // increment head pointer after removing one
            }
        } else {
            throw new CircularQueueException("Queue is empty");
        }
        return val;
    }

    private boolean isEmpty(){
        if(head == -1 && tail == -1) return true;
        return false;
    }

    private boolean isFull(){
        if((tail + 1) % size == head){
            return true;
        }
        return false;
    }

    static class CircularQueueException extends RuntimeException {
        public CircularQueueException(String msg){
            super(msg);
        }
    }
}


