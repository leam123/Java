import java.io.*;

public class ReadFileDirectory{
    public String readfile(String directory,String filename){
        StringBuffer sb = new StringBuffer(20);
        try{
            File file1 = new File(directory, filename);
            FileReader freader = new FileReader(file1);
            int i=0;
            if(!file1.exists()){
                while((i = freader.read()) != -1){
                    sb.append((char)i);
                }
            }else{
                while((i = freader.read()) != -1){
                    sb.append((char)i);
                }
            }
        }catch(FileNotFoundException ex){

        }catch(IOException ex){

        }
        return sb.toString();
    }
}