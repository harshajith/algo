import leetcode.jan.CircularQueue;
import org.junit.Before;
import org.junit.Test;

public class CircularQueueTest {

    CircularQueue circularQueue;
    @Before
    public void setup(){
        circularQueue = new CircularQueue(4);
    }

    @Test
    public void testEnqueue(){
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        circularQueue.enqueue(3);
        circularQueue.enqueue(5);
        circularQueue.enqueue(4);
        circularQueue.enqueue(6);
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
    }



}
