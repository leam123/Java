import java.lang.Thread;

public class Animate implements Runnable{
    Game block;
    
    public Animate(Game block){
        this.block = block;
    }
    
    public void run(){
        while(true){
            block.update();
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                System.out.print(e);
            }
        }
    }
 
    
 
}