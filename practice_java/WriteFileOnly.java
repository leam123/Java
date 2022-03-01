import java.io.*;

public class WriteFileOnly{
    public boolean writefile(String filename, String content){
        boolean ok = false;
        try{
            FileWriter file = new FileWriter(filename,true);
            char ch[] = content.toCharArray();
            for(char c: ch){
                file.write(c);
            }
            file.close();
            ok = true;
        }catch(FileNotFoundException ex){

        }catch(IOException ex){

        }

        return ok;
    }
}