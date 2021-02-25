import java.util.ArrayList;

public class genheap<T extends Comparable<T>> {
    private ArrayList<T> heap;

    /**
     * Genericn heap constructor
     */
    public genheap() {
        this.heap = new ArrayList<T>();
    }

    /**
     * adds data to heap then rebalances with heapify up
     * @param value generic value to be added
     */
    public void add(T value) {
        this.heap.add(value);
        this.heapifyup(this.heap.size() - 1);
    }

    /**
     * removes the top data (switches data with last node then deletes that node) then rebalances with heapify down
     */
    public void remove() {
        this.heap.set(0, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);
        this.heapifydown(0);
    }

    /**
     * checks if heap has data
     * @return a boolean if the heap is empty or not
     */
    public boolean isEmpty() {
        return this.heap.isEmpty();
    }

    /**
     * returns top node
     * @return the data of the first node in the heap
     */
    public T peek() {
        if (this.heap.size() == 0) {
            return null;
        }
        return this.heap.get(0);
    }

    /**
     * gets heap size
     * @return the exact length of the heap
     */

    public int getLength (){
        return heap.size();
    }


    //starts from the inputted position then checks children node for the smaller node to recursively move data down the tree
    private void heapifydown(int in) {
        int left = in * 2 + 1;
        int right = left + 1;

        //two nodes
        if (right < heap.size()) {
            //right is smaller
            if (heap.get(left).compareTo(heap.get(right)) == 1 && heap.get(right).compareTo(heap.get(in)) == -1) {
                T inttemp = heap.get(in);
                heap.set(in, heap.get(right));
                heap.set(right, inttemp);
                heapifydown(right);
            }
            //left is smaller
            else if (heap.get(left).compareTo(heap.get(right)) == -1 && heap.get(left).compareTo(heap.get(in)) == -1) {
                T inttemp = heap.get(in);
                heap.set(in, heap.get(left));
                heap.set(left, inttemp);
                heapifydown(left);
            }
        } if (left < heap.size()){
            if(heap.get(left).compareTo(heap.get(in)) == -1){
                T inttemp = heap.get(in);
                heap.set(in, heap.get(left));
                heap.set(left, inttemp);
                heapifydown(left);
            }
        }


    }




    //starts from the inputted position then checks parent node to see if it is larger then recursively moves up the tree
    private void heapifyup(int in) {
        if (in > 0 && this.heap.get(in).compareTo(this.heap.get((in - 1) / 2)) == -1) {
            T inttemp = this.heap.get((in - 1) / 2);
            this.heap.set((in - 1) / 2, this.heap.get(in));
            this.heap.set(in, inttemp);

            this.heapifyup((in - 1) / 2);
        }


    }


}
