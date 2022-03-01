import java.util.*;
public class Second {
	public static void main(String args[]) {
		List<String> myList = new ArrayList<String>(10);
		myList.add("Hello");
		myList.add("Abc");
		myList.add("Xyz");
		myList.add("Hi");
		for (String i: myList)
		   System.out.println(i);

        System.out.println("sort...");

        Collections.sort(myList);
		for (String i: myList)
		   System.out.println(i);
	}
}
