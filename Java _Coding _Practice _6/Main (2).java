public class Main{
	public static void main(String[] args){
		for(int i=0;i<5;i++){
			System.out.print(new RecursionFibonacci().recursive_fib(i) + " ");
		}
		String str = "Leamor Garcia";
		System.out.println("\n" + new RecursiveReverse().reverse(str));

		//String str2 = "Garcia Leamor";
		//System.out.println(new RecursiveReverse().reverse1(str2));

		String str2 = "Madam";
		System.out.println("Is " + str2 + " a palindrome: " + new Palindrome().isPalindrome(str2));
		//System.out.println("Is " + str2 + " a palindrome: " + new Palindrome().isPal(str2));
	}
}