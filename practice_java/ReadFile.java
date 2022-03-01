import java.io.*;

public class ReadFile{
    public String readfile(String filename){
        StringBuffer sb = new StringBuffer(20);
        try{
            FileReader freader = new FileReader(filename);
            int i=0;
            while((i = freader.read()) != -1){
                sb.append((char)i);
            }
        }catch(FileNotFoundException ex){

        }catch(IOException ex){

        }
        return sb.toString();
    }
}