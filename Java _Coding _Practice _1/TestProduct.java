import java.util.*;
import java.lang.*;
public class TestProduct{
        public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Product p = new Product();
        char ans='n';
        String name;
        do{
            int ct=1;
            p.setCode(ct);
            System.out.print("Input product name: ");
            name=input.next();
            p.setName(name);
            System.out.print("Input product cost: ");
            float cost=input.nextFloat();
            p.setCost(cost);
            System.out.print("Input number of stocks: ");
            int stock=input.nextInt();
            p.setStock(stock);
            System.out.print("Enter items to sell: ");
            int count=input.nextInt();
            boolean sell=p.sell(count);
            if(sell==true){
                int st=p.getStock()-count;
                p.setStock(st);
                System.out.println(p.toString());
            }
            else{
                System.out.println("Insuffient Stock");
                System.out.print("Enter items to sell: ");
                count=input.nextInt();
                int st = p.getStock()-count;
                p.setStock(st);
                System.out.println(p.toString());
            }
            System.out.println("Enter items to purchase: ");
            count=input.nextInt();
            int pc = p.purchase(count);
            p.setStock(pc);
            System.out.println(p.toString());
            System.out.print("Increase price rate: ");
            float rate = input.nextFloat();
            float r = p.priceIncrease(rate);
            p.setCost(r);
            System.out.println(p.toString());
            System.out.print("Add new product <y/n>? ");
            ans=input.next().charAt(0);
            if(ans=='y'){
                ct = p.getCounter();
                p.setCode(ct);
            }
        }while(ans=='y');
    }
}