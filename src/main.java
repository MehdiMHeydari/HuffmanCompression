import java.io.*;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;

public class main {

    public static void main (String[] args) throws IOException{




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




/*
        genheap obj = new genheap();

        for(int i = 0; i < num; i++) {
           obj.add(scan.nextInt());
        }

       for(int i = 0; i < num; i++) {
           System.out.println(obj.heap.get(i));
       }

*/

        writer.close();

    }
}
