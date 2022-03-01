import java.util.*;
public class TestClass{
    public static void main(String[] args){
        int ans=1;

        do{
            menu();

        }while(ans==1);
    }

    public static void menu(){
		Scanner s = new Scanner(System.in);
		int ans=1, days, choice;
		double sal;
        String name, spec;

		System.out.println("\n\nMENU\n[1]Doctor\n[2]Programmer\n[3]Exit\n");
		System.out.print("Enter choice: ");
        choice = s.nextInt();

        switch(choice){
			case 1: System.out.print("\nID Number: ");
					int id = s.nextInt();
					System.out.print("Name: ");
					s.nextLine();
					name = s.nextLine();
					System.out.print("Specialization: ");
					spec = s.nextLine();
					Doctor d = new Doctor(id,name,spec);
					System.out.print("Number of days worked: ");
					days = s.nextInt();
					if(days<=30){
						sal = d.calculateSalary(days);
					}else{
						System.out.print("No. of days must not exceed 30.");
						menu();
					}
					System.out.print("\nDoctor's Information: ");
					d.display();
					break;
			case 2: System.out.print("\nID Number: ");
					id = s.nextInt();
					System.out.print("Name: ");
					s.nextLine();
					name = s.nextLine();
					System.out.print("Specialize Language: ");
					spec = s.nextLine();
					Programmer p = new Programmer(id,name,spec);
					System.out.print("Number of days worked: ");
					days = s.nextInt();
					if(days<=30){
						sal = p.calculateSalary(days);
					}else{
						System.out.print("No. of days must not exceed 30.");
						menu();
					}
					System.out.print("\nProgrammer's Information: ");
					p.display();
					break;
			case 3: break;
			default: break;
		}
	}
}