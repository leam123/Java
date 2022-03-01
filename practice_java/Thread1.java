import java.util.Random;
public class Thread1 implements Runnable{
    private int i;
    public void run(){
        for(i=0;i<3;i++){
            System.out.println("I Love Java");
        }
        
        try{
            Thread.sleep((int)(Math.random() * 30000));
        }catch(InterruptedException ie){
            System.out.println(ie);
        }
    }
}