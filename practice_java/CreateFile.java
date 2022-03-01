import java.io.*;

public class CreateFile{
    public void create(String directory,String filename) throws FileNotFoundException, IOException{
        File dir = new File(directory);
        dir.mkdir();
        
        File file1 = new File(dir,filename);
        if(!file1.exists()){
            file1.createNewFile();
        }else{
            System.out.println("Already exist");
        }
    }
    public static void main(String[] args){
        CreateFile cf = new CreateFile();
        try{
            cf.create("Directory","File1.txt");
        }catch(FileNotFoundException ex){
            
        }catch(IOException ex){
            
        }
    }
}