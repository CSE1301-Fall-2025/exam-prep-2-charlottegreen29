package nonexam.fibonacci;

public class Fibonacci {

	/*
	 * Instructions for this extension can be found here:
	 * 
	 * https://131text.com/ns/books/published/csjava/Extensions/6.04.html
	 */

	public static int recursive(int n) {
		if (n==0){
			return 0;
		}
		else if (n==1){
			return 1;
		}
		else {
			return recursive(n-1) + recursive(n-2);
		}
		
	}

	/**
	 * Below write your solution to Fibonacci, using iteration
	 * 
	 * @param n
	 * @return the nth Fibonacci number, computed iteratively
	 */
	public static int iterative(int n) {
		int sum = 0;
		if (n==0){
			sum = 0;
		}
		else if (n==1){
			sum = 1;
		}
		else{
			int i = 2;
			int sum0=0;
			int sum1=1;
			while (i<=n){
				sum = sum0+sum1;
				sum0 = sum1;
				sum1 = sum;
				i++;
			}
		}
		return sum;
	}

}
