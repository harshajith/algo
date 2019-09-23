package aws.s3;

public class CircularQueue {

    int size = 0;
    int Max_Size;
    int[] queue;
    int front;
    int rear;

    public CircularQueue(int max_size){
        queue = new int[max_size];
        size = 0;
    }

    /**
     * EnQueue at last position
     * @param val
     */
    private void enQueue(int val){
        //check if Q is full
        if(size == queue.length){
            throw new RuntimeException("Q full");
        }

        if(front != 0 && (rear == size -1)){
            rear = 0;
            queue[rear] = val;
            size ++;
        }else {
            queue[rear++] = val;
            size++;
        }


    }

    private void printQueue(){
        for(int i=0;i<queue.length;i++){
            System.out.println(queue[i]);
        }
    }
    /**
     * DeQueue fron front
     * @return
     */
    private int deQueue(){
        return 0;
    }

    public static void main(String[] args){
        CircularQueue q = new CircularQueue(2);
        q.enQueue(3);
        q.enQueue(5);
        q.enQueue(2);


        q.printQueue();
    }

}
