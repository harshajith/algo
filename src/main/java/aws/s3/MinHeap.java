package aws.s3;

/**
 *
 * MinHeap always have the min value at the top, once we remove top which is O(1), we need to
 * heapify the tree again, start to heapify from the bottom to keep the min value at the top again, use an array to implement.
 *         3
 *       /  \
 *     4    5
 *   /  \  / \
 *  7   8 9   10
 *
 */
public class MinHeap {
    int size = 0; // number of elements present in heap array
    int MAX_SIZE;
    int[] HEAP;
    int FRONT = 0;

    MinHeap(int max_size){
        this.MAX_SIZE = max_size;
        this.HEAP = new int[MAX_SIZE];
    }

    /**
     * Any binary tree, leftChild is at 2*i+1, rightChild is at 2*i+2
     * Hence, if i is > size/2, there will not be a child node.
     * @param pos
     * @return
     */
    private boolean isLeaf(int pos){
        if(pos >= size/2 && pos <= size) return true;
        return false;
    }

    /**
     * Insert at the end
     * @param value
     */
    private void insert(int value){
        if(size >= MAX_SIZE){
            return;
        }
        HEAP[size] = value; // add the value at last index
        int current = size++; // actual index of the element.

        while(HEAP[parentIndex(current)] > HEAP[current]){
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }
    }

    private int remove(){
        int top = HEAP[FRONT];
        HEAP[FRONT] = HEAP[--size]; // put last element at the top
        heapify(FRONT);
        return top;
    }

    private void swap(int index1, int index2){
        int tmp = HEAP[index1];
        HEAP[index1] = HEAP[index2];
        HEAP[index2] = tmp;
    }

    private int parentIndex(int pos){
        return (pos-1)/2;
    }

    private int getLeftChildIndex(int pos){
        return pos*2 + 1;
    }

    private int getRightChildIndex(int pos){
        return pos*2 + 2;
    }

    private void heapify(int pos){
        if(isLeaf(pos)) return;

        int leftIndex = getLeftChildIndex(pos);
        int rightIndex = getRightChildIndex(pos);
        int leftVal =  HEAP[leftIndex];
        int rightVal = HEAP[rightIndex];

        if(HEAP[pos] > leftVal || HEAP[pos] > rightVal){
            if(rightVal < leftVal){
                swap(pos, rightIndex);
                heapify(rightIndex);
            }else {
                swap(pos, leftIndex);
                heapify(leftIndex);
            }
        }
    }

    public static void main(String[] args){
        MinHeap mh = new MinHeap(8);
        mh.insert(4);
        mh.insert(3);
        mh.insert(2);
        mh.insert(1);
        mh.insert(5);

        int min = mh.remove();

        System.out.println(mh.HEAP.toString());
    }

}
