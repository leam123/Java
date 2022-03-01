import java.util.*;
public class First {
	public static void main(String args[]) {
		List<Integer> myList = new ArrayList<Integer>(10);
		//List<Object> myList = new ArrayList<Object>(10);
		myList.add(10);  // OK ???
		myList.add(100);
		myList.add(9);
		myList.add(11);
		myList.add(3);
		myList.add(500);
		//myList.add("Hello, World"); // OK ???
		for (Integer i: myList)
		   System.out.println(i);

        System.out.println("sort...");

        Collections.sort(myList);
		for (Integer i: myList)
		   System.out.println(i);

		//0000 1010 >> 1 = 0000 0101
		//byte 127 to -128
		//byte b = 127;
		//byte a = -128;
		//System.out.println(b << 1);
	}
}
