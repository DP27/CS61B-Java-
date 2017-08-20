/**
You'll now create a function with the signature public static int max(int[] m) that returns the maximum value of an int array. You may assume that all of the numbers are greater than or equal to zero.

Modify the code below (also found here) so that max works as described. Furthermore, modify main so that the max method is called on the given array and its max printed out
*/

public class max_class {
   public static int max(int[] m) {
       int x=0;
       int max_value=0;
       while (x<m.length){
	   if (x==0){
	       max_value=m[x];
	   }
	   else{
	       if(max_value < m[x]){
		   max_value=m[x];	   
	       }
	   }
	   x=x+1;
       }
       return max_value;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
      System.out.println("Max Value is:");
      System.out.println(max_class.max(numbers));
   }
}
