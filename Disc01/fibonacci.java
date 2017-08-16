/** fib(n) returns the nth Fibonacci number, for n ≥ 0.
* The Fibonacci sequence is 0, 1, 1, 2, 3, 5, 8, 13, 21, ... */
public class fibonacci{
    public static int fib_function(int n){
	if (n == 0){
	    return 0;
	}
	else if (n==1){
	    return 1;
	}
	else {
	    return fib_function(n-1)+fib_function(n-2);
	}
    }
    public static void main(String[] args){
       
	System.out.println("Fibonacci Implementation");
	System.out.println(fibonacci.fib_function(6));


    }

}
