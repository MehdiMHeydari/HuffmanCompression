import java.util.*;

public class Huffman {


    public HashMap<Character, String> compress(String in){

        HashMap<Character, Integer> freqtbl = createfreqtbl(in);

        Set<Character> freqset = freqtbl.keySet();


        //sort lexographically
        BST bst = new BST();
        for (Character temp : freqset) {
            BSTHuffmanNode node = new BSTHuffmanNode();
            node.letter = temp;
            node.frequency = freqtbl.get(temp);
            bst.add(node);
        }
        List<BSTHuffmanNode> sortedlist = bst.inOrder();



        //sort by frequency
        genheap<heapHuffmanNode> heap = new genheap();

        for (int i = 0; i < sortedlist.size(); i ++){
            BSTHuffmanNode transfer = sortedlist.get(i);
            heapHuffmanNode newnode = new heapHuffmanNode();
            newnode.frequency = transfer.frequency;
            newnode.letter = transfer.letter;
            heap.add(newnode);
        }

        heapHuffmanNode root = createHuffmanTree(heap);

        HashMap<Character, String> dictionary = new HashMap<>();
        createDictionary(root, "", dictionary );

        for(int i = 0; i < dictionary.size(); i++){
            Character letter = sortedlist.get(i).letter;
            System.out.println(letter + ": " + dictionary.get(letter));
        }


        return dictionary;
    }



    public HashMap<Character, Integer> createfreqtbl (String in){
        HashMap<Character, Integer> freqtbl = new HashMap<>();

        for(int i = 0; i < in.length(); i++){
            if(!freqtbl.containsKey(in.charAt(i))){
                freqtbl.put(in.charAt(i), 1);
            }else{
                freqtbl.put(in.charAt(i), freqtbl.get(in.charAt(i)) + 1);
            }
        }
        return freqtbl;
    }

    public heapHuffmanNode createHuffmanTree (genheap<heapHuffmanNode> heap){
        heapHuffmanNode root = null;
        while(heap.getLength() != 1){

            heapHuffmanNode leftnode = heap.peek();
            heap.remove();

            heapHuffmanNode rightnode = heap.peek();
            heap.remove();

            heapHuffmanNode parent = new heapHuffmanNode();
            parent.frequency  = rightnode.frequency + leftnode.frequency;
            parent.letter = '*';
            parent.left = leftnode;
            parent.right = rightnode;

            root = parent;
            heap.add(root);

        }
        return root;
    }


    public void createDictionary (heapHuffmanNode in, String path, HashMap<Character, String> dict){

        heapHuffmanNode current = in;

       if(current.left != null && current.right != null){
           createDictionary(in.left, path + "0", dict);
           createDictionary(in.right, path + "1", dict);
        }else {
           dict.put(in.letter, path);
       }
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

        heapHuffmanNode left = null;
        heapHuffmanNode right = null;

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
