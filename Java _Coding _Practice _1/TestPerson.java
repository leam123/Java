public class TestPerson{
   public static void main(String[] args){
       Address add = new Address(123,"N.Bacalso","Kalunasan","Cebu City","Bohol",6000);
       Bdate bdate = new Bdate("October",25,1999);
       Person emp = new Employee ("Leamor T. Garcia",add,bdate,"16-0265-749","Student");
       Person emp1 = new Employee ("Leamor T. Garcia",add,bdate,"16-0265-749","Student");
       System.out.println(emp.toString());
       System.out.println(emp.equals(emp1));
   }
}

