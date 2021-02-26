import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.io.FileReader;

public class main {


    public static void main (String[] args) throws IOException{

        //object to run huffman compression
        Huffman huff = new Huffman();

        //handles command line input
        Scanner scan = new Scanner(System.in);
        String inputcmd = scan.nextLine();
        String[] cmds = inputcmd.split(" ");
        BufferedReader list = new BufferedReader(new FileReader(cmds[cmds.length-1]));

        //determines outputfile name
        String outputfilname = "";
        for(int i = 0; i < cmds.length; i++){
            if(cmds[i].equals("-o")){
                outputfilname = cmds[i+1];
            }
        }

        //creates outputfile
        PrintWriter writer = new PrintWriter(outputfilname);
        StringBuilder sb = new StringBuilder();

        //reads file input
        String line = "";
        while((line=list.readLine()) != null) {
            sb.append(line).append("\n");
        }

        String contents = sb.toString();

        HashMap<Character, String> dictionary = huff.compress(contents);

        SortedMap<Character, String> myNewMap = new TreeMap<Character, String>(dictionary);

        Set<Character> keys = myNewMap.keySet();


        //writes dictionary to output file
        for (Character temp : keys) {

            if(temp.equals('\n')){
                writer.println("enter" + ": " + dictionary.get(temp));
            }else if(temp.equals('\t') ){
                writer.println("tab" + ": " + dictionary.get(temp));
            }else if(temp.equals(' ') ){
                writer.println("space" + ": " + dictionary.get(temp));
            }else {
                writer.println(temp + ": " + dictionary.get(temp));
            }
        }

/*


 */



       writer.close();

    }
}
