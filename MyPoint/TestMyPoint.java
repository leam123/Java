import java.util.*;
import java.text.DecimalFormat;
public class TestMyPoint{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        MyPoint p = new MyPoint();
        MyPoint p1 = new MyPoint(0,0);
        MyPoint p2 = new MyPoint(0,0);
        System.out.print("x1: ");
        int x1 = input.nextInt();
        p1.setX(x1);
        System.out.print("y1: ");
        int y1 = input.nextInt();
        p1.setY(y1);
        System.out.print("x2: ");
        int x2 = input.nextInt();
        p2.setX(x2);
        System.out.print("y2: ");
        int y2 = input.nextInt();
        p2.setY(y2);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(df.format(p.getDistance(p1,p2)));
    } 
}