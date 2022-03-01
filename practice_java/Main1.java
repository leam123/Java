import java.io.*;
public class Main1{
     public static void main(String[] args){
        ReadFile rf = new ReadFile();
        WriteFileOnly w = new WriteFileOnly();

        boolean z = w.writefile("Wow.txt","I Love Java");
        boolean x = w.writefile("Wow.txt","\nJAVA MASTER");
        boolean j = w.writefile("Wow.txt","\n4.33333\n");
  		String str = rf.readfile("Wow.txt");
        System.out.println(str);
    }
}