import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class main {

    public static void main (String[] args) throws IOException{



        Huffman huff = new Huffman();

        Scanner scan = new Scanner(System.in);


        String inputcmd = scan.nextLine();
        String[] cmds = inputcmd.split(" ");
        BufferedReader list = new BufferedReader(new FileReader(cmds[cmds.length-1]));


       String outputfilname = "";
        for(int i = 0; i < cmds.length; i++){
            if(cmds[i].equals("-o")){
                outputfilname = cmds[i+1];
            }
        }
        PrintWriter writer = new PrintWriter(outputfilname);

        StringBuilder sb = new StringBuilder();

        String line = "";
        while((line=list.readLine()) != null) {
            sb.append(line).append("\n");
        }

        String contents = sb.toString();

        HashMap<Character, String> dictionary = huff.compress(contents);
        Set<Character> keys = dictionary.keySet();


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
