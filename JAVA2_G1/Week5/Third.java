import java.util.*;
public class Third {
	public static void main(String args[]) {
		List<PhoneContact> myList = new ArrayList<PhoneContact>(10);
		myList.add(new PhoneContact("Ben","2123"));
		myList.add(new PhoneContact("Barbie","0123"));
		myList.add(new PhoneContact("Olaf","5123"));
		myList.add(new PhoneContact("Ana","6123"));
		myList.add(new PhoneContact("Elsa","6123"));
		for (PhoneContact i: myList)
		   System.out.println(i);

        System.out.println("sort...");

        Collections.sort(myList);
		for (PhoneContact i: myList)
		   System.out.println(i);

	}

}
