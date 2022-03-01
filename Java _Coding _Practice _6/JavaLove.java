import java.io.*;
public class JavaLove implements Runnable{
	public void run(){
		for(int i=0;i<3;i++){
			System.out.println("I Love Java");
		}
		try{
			Thread.sleep((int)(Math.random() * 3000));
		}catch(InterruptedException ie){
			System.out.println(ie);
		}
	}
}