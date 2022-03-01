import java.io.*;

public class Person implements Serializable{
	private String name;
	private int age;
	public Person(String name, int age){
		this.name =  name;
		this.age = age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setName(String name){
		this.name =  name;
	}
	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return "Name: " + name + " Age: " + age;
	}
}