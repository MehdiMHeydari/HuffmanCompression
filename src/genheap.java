import java.util.ArrayList;

public class genheap {
    public ArrayList<Integer> heap;

    public genheap(){
        this.heap = new ArrayList<Integer>();

    }

    public void add (Integer value){
       // System.out.println("hi");
        this.heap.add(value);
        this.heapifyup(this.heap.size() - 1);
    }

    public void remove (){


        this.heap.set(0, this.heap.size()-1);
        this.heap.remove(this.heap.size()-1);

        this.heapifydown(this.heap);
    }

    public boolean isEmpty(){
        return this.heap.isEmpty();
    }

    public Integer peek(){
        return this.heap.get(0);
    }

    private void heapifydown(ArrayList<Integer> in){
        ArrayList<Integer> temp = in;

        //System.out.println("hi");

       // for(int i = 0; i < temp.size(); i ++) {
       //     System.out.println(temp.get(i));
     //   }

        for ( int i = 0; i < temp.size(); i++){
            if (i * 2 + 2 < temp.size()){
                if (temp.get(i * 2 + 1) < temp.get(i * 2 + 2) && temp.get(i * 2 + 1) < temp.get(i)){
                    Integer inttemp = temp.get(i);
                    temp.set(i, temp.get(i * 2 + 1));
                    temp.set(i * 2 + 1, inttemp);
                    heapifydown(temp);
                }else if(temp.get(i * 2 + 1) > temp.get(i * 2 + 2) && temp.get(i * 2 + 2) < temp.get(i)){
                    Integer inttemp = temp.get(i);
                    temp.set(i, temp.get(i * 2 + 2));
                    temp.set(i * 2 + 2, inttemp);
                    heapifydown(temp);
                }
            }else if (i * 2 + 1 < temp.size()){
                if (temp.get(i * 2 + 1) < temp.get(i)){
                    Integer inttemp = temp.get(i);
                    temp.set(i, temp.get(i * 2 + 1));
                    temp.set(i * 2 + 1, inttemp);
                    heapifydown(temp);
                }
            }
            else{
                break;
            }
        }

        heap = temp;

       /* for(int i = 0; i < heap.size(); i ++) {
            System.out.println(heap.get(i));
        }*/

    }

    private void heapifyup(int i){

            if(i > 0 && this.heap.get(i) < this.heap.get((i-1)/2)){
                Integer inttemp = this.heap.get((i-1)/2);
                this.heap.set((i-1)/2, this.heap.get(i));
                this.heap.set(i, inttemp);
                heapifyup((i-1)/2);
            }



    }



}
