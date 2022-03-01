import java.io.FileWriter;
import java.io.*;

public class WriteFileAlreadyExists{
    String filename;
    String content;
    // TESTING IF WE CAN APPEND TO AN ALREADY EXISTING FILE
    public boolean writefile(String directory,String filename, String content) throws IOException, FileNotFoundException{
        boolean ok = false;
        File dir = new File(directory);
        dir.mkdir();
        File file1 = new File(dir, filename);
        FileWriter fw = new FileWriter(file1,true);
        char ch[] = content.toCharArray();
        if(!file1.exists()){
            file1.createNewFile();
            for(char c : ch){
                fw.write(c);
            }
            fw.close();
            ok = true;
        }else{
            for(char c : ch){
                fw.write(c);
            }
            fw.close();
            ok = true;
        }
        return ok;
    }
    public static void main(String[] args){
        WriteFileAlreadyExists write = new WriteFileAlreadyExists();
        ReadFileDirectory rd = new ReadFileDirectory();
        try{
            boolean y = write.writefile("Directory1","File1.txt","I Love Java");
            boolean x = write.writefile("Directory1","File1.txt","\nWow\n");
            //System.out.print(w);
            String str = rd.readfile("Directory1","File1.txt");

            System.out.print(str);
        }catch(FileNotFoundException ex){

        }catch(IOException ex){

        }
    }
}