import java.util.*;

public class PersonCompare implements Comparator<Person>{
   	 public int compare(Person p1, Person p2){
		//Sort Strings
		return p1.getName().compareToIgnoreCase(p2.getName());

		//Sort integers
		//return Integer.valueOf(p1.getAge()).compareTo(Integer.valueOf(p2.getAge()));
	}
}