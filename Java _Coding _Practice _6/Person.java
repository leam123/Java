import java.util.*;

public class Person implements Comparable<Person>{
	private String name;
	private int age;

	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	 public String toString(){
	       return "Name:"+name +"\nAge:"+age;
    }

    //Sorting String
    public int compareTo(Person anotherPerson){
		return compare(this.name, anotherPerson.name);
	}
	public static int compare(String p1, String p2){
		int len1 = p1.length();
		int len2 = p2.length();
		int limit = Math.min(len1,len2);
		char a1[] = p1.toCharArray();
		char a2[] = p2.toCharArray();
		int i=0;
		while(i<limit){
			char ch1 = a1[i];
			char ch2 = a2[i];
			if(ch1 != ch2){
				return ch1 - ch2;
			}
			i++;
		}
		return len1 - len2;
	}

	//Sorting integers
	public static int compare(int x, int y) {
	        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}