public class Recursion{
	public int summation(int n){
		if(n==1){
			return 1;
		}
		else{
			return n + summation(n - 1);
		}
	}

	public static void main(String[] args){
		System.out.println(new Recursion().summation(5));
	}
}
