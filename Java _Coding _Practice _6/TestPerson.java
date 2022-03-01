import java.util.*;

public class TestPerson{
	public static void main(String[] args){
		List<Person> mylist = new ArrayList<Person>(10);

		mylist.add(new Person("Leamor",19018));
		mylist.add(new Person("Garcia",45678));
		mylist.add(new Person("Adonis",19118));
		mylist.add(new Person("deadpool",19028));
		mylist.add(new Person("bikini bottom",100018));

		System.out.println("List");
		for(Person l: mylist){
			System.out.println(l);
		}

		System.out.println("\nSorted using Comparator");
		//Comparator<>
		//make another class that implements comparator and then override int compare method...
		Collections.sort(mylist, new PersonCompare());
		Iterator<Person> it = mylist.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		System.out.println("\nSorted using Comparable");
		//Comparable<>
		//implements comparable in the class and then override int compareTo method...
		Collections.sort(mylist);
		for(Person p: mylist){
			System.out.println(p);
		}

		System.out.println("\nSorted using Comparator in one line code");
		//One line sorting of strings using comparator<>
		Collections.sort(mylist, Comparator.comparing(Person::getName));
		for(Person p: mylist){
			System.out.println(p);
		}
		System.out.println("\nBackwards");
		//Reversed sort
		Collections.sort(mylist, Comparator.comparing(Person::getName).reversed());
		for(Person p: mylist){
			System.out.println(p);
		}

		//Sort by Age
		//Collections.sort(mylist, Comparator.comparing(Person::getAge));

		//Iterate backwards in the list
		/*ListIterator<Person> li = mylist.listIterator();
		while(li.hasPrevious()){
			System.out.println(li.previous());
		}*/
	}
}