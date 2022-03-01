
/** HAVE MANY DIFFERENT CLASSES
 * 
 * 
 * Re-define Address, Bdate and Person classes. (Base your answer in the notes given)
 * 
 * Define a class Employee. Make this class a subclass of Person with additional data members -
 * String idnum and position. Define the following methods:
 * - 2 constructors (default constructor and one that accepts all parameters initialized accordingly)
 * - getter methods for name, address, bdate, idnumber and position
 * - overrride toString to output in this manner (name, address, bdate, idnumber, position) and equals method
 *
 * Author: Leamor T. Garcia
 * Date: 28/7/2019 
 */
class Address{
     private int houseNo, code;
     private String street, brgy, city, prov;
     public Address(){}
     public Address(int houseNo, String street, String brgy, String city, String prov, int code){
         this.houseNo = houseNo;
         this.code = code;
         this.street = street;
         this.brgy = brgy;
         this.city = city;
         this.prov = prov;
    }
    public int getHouseNo(){return houseNo;}
    public int getCode(){return code;}
    public String getStreet(){return street;}
    public String getBrgy(){return brgy;}
    public String getCity(){return city;}
    public String getProv(){return prov;}
    
    public String toString(){
        return "Address: " + getHouseNo() + "" + getStreet() + "," + getBrgy() + "" + getCity();
    }
}

class Bdate{
     private int day, year;
     private String month;
     public Bdate(){}
     public Bdate(String month,int day,int year){
         this.day = day;
         this.year = year;
         this.month = month;
    }
    public int getDay(){return day;}
    public int getYear(){return year;}
    public String getMonth(){return month;}
    
    public String toString(){
        return "Birthday:" + getMonth() + " " + getDay() + "," + getYear();
    }
}

class Person{
     private Address add;
     private Bdate bdate;
     private String name;
     public Person(){}
     public Person(String name, Address add, Bdate bdate){
         this.name = name;
         this.add = add;
         this.bdate = bdate;
    }
    public Bdate getBdate(){return bdate;}
    public Address getAddress(){return add;}
    public String getName(){return name;}
    
    public String toString(){
        return  getName() + getAddress() +  getBdate();
    }
}

class Employee extends Person{
       private String idNum, position;
       public Employee(){}
       public Employee(String name, Address add, Bdate bdate, String idNum, String position){
           super(name,add,bdate);
           this.idNum = idNum;
           this.position = position;
       }
       public String getIdNum(){return idNum;}
       public String getPosition(){return position;}
       public String toString(){
           return super.toString() + getIdNum() + getPosition();
       }
       public boolean equals(Object obj){
           if (obj instanceof Employee)
                return true;
           else
                return false;
       }
}
