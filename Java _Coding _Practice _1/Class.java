public class Class implements Method{
    public void display(int x){
        System.out.println(x);
    }
    public static void main(String[] args){
        int x=10;
        Class c = new Class();
        c.display(x);
    }
}
