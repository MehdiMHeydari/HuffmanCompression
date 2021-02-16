import java.util.*;

public class Huffman {


    public ArrayList<String> compress(String in){

        HashMap<Character, Integer> freqtbl = createfreqtbl(in);

        Set<Character> freqset = freqtbl.keySet();


        //sort lexographically
        BST bst = new BST();
        for (Character temp : freqset) {
           // System.out.println(temp + ": " + freqtbl.get(temp));
            BSTHuffmanNode node = new BSTHuffmanNode();
            node.letter = temp;
            node.frequency = freqtbl.get(temp);
            bst.add(node);
        }
        List<BSTHuffmanNode> sortedlist = bst.inOrder();



        //sort by frequency
        genheap<heapHuffmanNode> heap = new genheap();

        for (int i = 0; i < sortedlist.size(); i ++){
           // System.out.println("" + ((int) sortedlist.get(i).letter.charValue()));

            BSTHuffmanNode transfer = sortedlist.get(i);
            heapHuffmanNode newnode = new heapHuffmanNode();
            newnode.frequency = transfer.frequency;
            newnode.letter = transfer.letter;
            System.out.println(newnode.frequency);
            heap.add(newnode);
        }

        System.out.println("\n");

        while(!heap.isEmpty()){
            System.out.println(heap.peek().frequency);
            heap.remove();
        }






    return null;
    }

    /*
    public ArrayList<String> decompress(){


    }

     */


    public HashMap<Character, Integer> createfreqtbl (String in){
        HashMap<Character, Integer> freqtbl = new HashMap<>();

        for(int i = 0; i < in.length(); i++){
            if(!freqtbl.containsKey(in.charAt(i))){
               // System.out.println(in.charAt(i));
                freqtbl.put(in.charAt(i), 1);
            }else{
                freqtbl.put(in.charAt(i), freqtbl.get(in.charAt(i)) + 1);
            }
        }

        return freqtbl;
    }


    private class BSTHuffmanNode implements Comparable<BSTHuffmanNode> {
        public Character letter;
        public int frequency;

        @Override
        public int compareTo(BSTHuffmanNode in) {
            return letter.compareTo(in.letter);
        }
    }
    private class heapHuffmanNode implements Comparable<heapHuffmanNode> {
        public Character letter;
        public int frequency;

        @Override
        public int compareTo(heapHuffmanNode in) {
            if(frequency < in.frequency){
                return -1;
            }else if(frequency > in.frequency){
                return 1;
            }
            return 0;
        }
    }




}
