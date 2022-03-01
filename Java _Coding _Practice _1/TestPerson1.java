import java.util.*;
public class TestPerson1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Employee1 emp1 = new Employee1("Leamor",20,43,"Manager");
        Employee1 emp4 = new Employee1("Leamor",20,43,"Manager");
        Employee1 emp2 = new Employee1("Jonald",22,42,"Head Organizer");
        Employee1 emp3 = new Employee1("Jonald",22,42,"Head Organizer");
        Student st1 = new Student("Ren",19,2,"BSIT");
        Student st2 = new Student("Jonald",22,42,"Head Organizer");
        System.out.println(emp1.toString());
        System.out.println("---------------------------------");
        System.out.println(emp2.toString());
        System.out.println("---------------------------------");
        System.out.println(st1.toString());
        System.out.println("---------------------------------");
        System.out.println(st2.toString());
        System.out.println("---------------------------------");
        System.out.println(emp3.equals(st2));
        System.out.println("---------------------------------");
        System.out.println(emp4.equals(emp1));
        System.out.println("---------------------------------");
        System.out.println("Input Name: ");
        String name = input.next();
        emp3.setName(name);
        System.out.println("---------------------------------");
        System.out.println(emp3.toString());
    }
}