import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;

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

       // System.out.println(contents);

        huff.compress(contents);







/*
        genheap obj = new genheap();

        int num = scan.nextInt();

        for(int i = 0; i < num; i++) {
           obj.add(scan.nextInt());
        }


       obj.remove();

        for(int i = 0; i < num-1; i++) {
            System.out.println(obj.heap.get(i));
        }

 */





       writer.close();

    }
}
