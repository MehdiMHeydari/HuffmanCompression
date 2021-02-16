import java.util.ArrayList;

public class genheap<T extends Comparable<T>> {
    public ArrayList<T> heap;

    public genheap() {
        this.heap = new ArrayList<T>();

    }

    public void add(T value) {
        // System.out.println("hi");
        this.heap.add(value);
        this.heapifyup(this.heap.size() - 1);
    }

    public void remove() {


        this.heap.set(0, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);

        this.heapifydown(0);
    }

    public boolean isEmpty() {
        return this.heap.isEmpty();
    }

    public T peek() {
        if (this.heap.size() == 0) {
            return null;
        }

        return this.heap.get(0);
    }

    private void heapifydown(int i) {

        //System.out.println("hi");

        // for(int i = 0; i < heap.size(); i ++) {
        //     System.out.println(heap.get(i));
        //   }
        int left = i * 2 + 1;
        int right = left + 1;

        //two nodes
        if (right < heap.size()) {
            //right is smaller
            if (heap.get(left).compareTo(heap.get(right)) == 1 && heap.get(right).compareTo(heap.get(i)) == -1) {
                T inttemp = heap.get(i);
                heap.set(i, heap.get(right));
                heap.set(right, inttemp);
                heapifydown(right);
            }
            //left is smaller
            else if (heap.get(left).compareTo(heap.get(right)) == -1 && heap.get(left).compareTo(heap.get(i)) == -1) {
                T inttemp = heap.get(i);
                heap.set(i, heap.get(left));
                heap.set(left, inttemp);
                heapifydown(left);
            }
        } if (left < heap.size()){
            if(heap.get(left).compareTo(heap.get(i)) == -1){
                T inttemp = heap.get(i);
                heap.set(i, heap.get(left));
                heap.set(left, inttemp);
                heapifydown(left);
            }
        }









    }

       /* for(int i = 0; i < heap.size(); i ++) {
            System.out.println(heap.get(i));
        }*/


    private void heapifyup(int in) {
//seperate base case in <=0
        //set parent index

        if (in > 0 && this.heap.get(in).compareTo(this.heap.get((in - 1) / 2)) == -1) {
            T inttemp = this.heap.get((in - 1) / 2);
            this.heap.set((in - 1) / 2, this.heap.get(in));
            this.heap.set(in, inttemp);

            this.heapifyup((in - 1) / 2);
        }


    }


}
