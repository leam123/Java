/**
** Calls an executable file
** @author LFeliz
** @date November 27, 2019
**/
import java.io.*;
public class ExecuteExe{
   public static void main(String args[]){
     Runtime r = Runtime.getRuntime();
     try {
	    //Process p = r.exec("notepad.exe");
	    //Process p = r.exec("mspaint.exe");
	    Process p = r.exec("calc.exe");
   	    p.waitFor();
     } catch (IOException | InterruptedException e) {
         e.printStackTrace();
     }
   }
}
