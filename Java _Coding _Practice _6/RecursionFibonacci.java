public class RecursionFibonacci{
	public int recursive_fib(int n){
		if(n<=1){
			return 1;
		}else{
			return recursive_fib(n-1) + recursive_fib(n-2);
		}
	}
}