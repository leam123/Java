/**
** Midterm review
** static keyword and recursion
*/
public class Factorial{
	//iterative
	public static int factorialV1(int n){
		int fact=1;
		for (int i=2; i<=n; i++)
		  fact*=i;
		return fact;
    }
    public static int factorialV2(int n){
		if (n==1)//base condition or base case
		   return 1;
		else
		   return factorialV2(n-1)*n;
    }

    public static void main(String args[]){
		System.out.println(factorialV1(5));

		Factorial f=new Factorial();
		System.out.println(f.factorialV1(5));
		//anonymous object
	    System.out.println(new Factorial().factorialV1(6));

	    System.out.println("Version 2");
		System.out.println(new Factorial().factorialV2(6));
		System.out.println(factorialV2(2));


		System.out.println(factorialV1(Integer.parseInt(args[0])));
		System.out.println(args[1]);

	}
}