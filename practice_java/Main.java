public class Main{
    public static void main(String[] args){
        Thread t = new Thread(new Thread1());
        t.start();
    }
}