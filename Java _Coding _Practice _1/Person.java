public class Person{
 private String name;
 private int age;
 
 public Person(){}
 public Person(String name, int age){
     this.name = name;
     this.age = age;
 }
 public String getName(){
     return name;
 }
 public int getAge(){
     return age;
 }
 public void setName(String name){
     this.name=name;
 }
 public void setAge(int age){
     this.age=age;
 }
 public boolean equals(Object obj){
     if(obj instanceof Person)
        return true;
     else
        return false;
 }
 public String toString(){
     return "Name: " + getName() + "\nAge: " + getAge();
 }
    
}