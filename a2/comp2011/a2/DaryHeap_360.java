package comp2011.a2; // Don't change this line!

/**
 *
 * You are forbidden to use {@code import} or {@code java.} in this file.
 *
 * Do not change the signature of any given method, but feel free to introduce new ones, which must be {@code private}.
 */

/**
 * VERY IMPORTANT.
 * 
 * I've sought help from the following GenAI:
 * 1.
 * 2.
 * 3.
 * ...
 * 
 * I've discussed this question with the following students (secret numbers, not names!):
 * 1.
 * 2.
 * 3.
 * ...
 * 
 * I've sought help from the following Internet resources and books:
 * 1.
 * 2.
 * 3.
 * ...
 * 
 * My secret number is 360, I'm implementing a 4-ary min (min/max) heap.
 */
public class DaryHeap_360<T extends Comparable<T>> {// Please replace 000 with your secret number!

    private int capacity;
    private T[] heap;
    private int size;

    public DaryHeap_360(int capacity) {
        this.capacity=capacity;
        size=0;
        heap=(T[]) new Comparable[capacity];
    }

    public void insert(T x) {
        if(size>=capacity){
            throw new IllegalStateException();
        }

        heap[size]=x;
        up(size);
        size++;
    }

    // Running time: O(log n).
    public T removeRoot() {
        if(size==0){
            return null;
        }

        T root=heap[0];
        heap[0]=heap[size-1];
        size--;
        down(0);
        return root;
    }

    // Running time: O(log n).
    private void up(int c) {
        int curNode=c;
        int dadNode=(curNode-1)/4;
        while(dadNode>=0&&heap[curNode].compareTo(heap[dadNode])<0){
            T temp=heap[curNode];
            heap[curNode]=heap[dadNode];
            heap[dadNode]=temp;
            curNode=dadNode;
            dadNode=(curNode-1)/4;
        }
    }

    // Running time: O(log n).
    private void down(int ind) {
        int curNode=ind;
        T minT;
        int min_ind;
        while(curNode*4+1<size){
            minT=heap[curNode*4+1];
            min_ind=curNode*4+1;
            for(int i=2;i<=4;i++){
                if(curNode*4+i>=size){
                    break;
                }
                if(heap[curNode*4+i].compareTo(minT)<0){
                    minT=heap[curNode*4+i];
                    min_ind=curNode*4+i;
                }
            }
            T temp = heap[curNode];
            heap[curNode] = heap[min_ind];
            heap[min_ind] = temp;
            curNode=min_ind;
        }
    }

    /**
     * Merge the given {@code heap} with {@code this}.
     * The result will be stored in {@code this}.
     *
     * VERY IMPORTANT.
     *
     * I've sought help from the following GenAI:
     * 1.
     * 2.
     * 3.
     * ...
     * 
     * I've discussed this question with the following students (secret numbers, not names!):
     * 1.
     * 2.
     * 3.
     * ...
     * 
     * I've sought help from the following Internet resources and books:
     * 1.
     * 2.
     * 3.
     * ...
     *
     * Running time: O(m+n). ("m+n" means that this.size+heap.size)
     */
    public void merge(DaryHeap_360<T> heap) {
        T[] newheap=(T[]) new Comparable[this.capacity+heap.capacity];
        this.capacity=this.capacity+heap.capacity;
        for(int i=0;i<this.size;i++){
            newheap[i]=this.heap[i];
        }
        for(int i=this.size;i<this.size+heap.size;i++){
            newheap[i]=heap.heap[i-this.size];
        }
        this.heap=newheap;
        this.size=this.size+heap.size;
        for (int i = (this.size - 1) / 4; i >= 0; i--) {
            this.down(i);
        }
    }
}


