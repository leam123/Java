import java.util.*;
import java.io.*;

public class Test{
	public static void main(String[] args){
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("Leamor", 20));
		list.add(new Person("Garcia", 21));
		list.add(new Person("BSIT", 3));

		Collections.sort(list,Comparator.comparing(Person::getName));
		//list.remove(2);
		try{
			//Save it on a File
			System.out.println(new FileHandling().serialize("Save.ser",list));
			list = (List<Person>) new FileHandling().deserialize("Save.ser");
			for(Person p: list){
				System.out.println(p);
			}
		}catch(IOException ie){

		}catch(ClassNotFoundException ie){

		}
	}
}