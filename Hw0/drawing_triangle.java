/**
Your goal is to create a program that prints the following figure. Your code should use loops (i.e. shouldn't just be five print statements, that's no fun).
*
**
***
****
*****
*/
import java.util.Scanner;
public class drawing_triangle{
    public static void print_func(int number_of_stages){
	int i=0;
	int j=0;
	while (j <= number_of_stages){
	    while (i < j){
		System.out.print("*");
		i+=1;
	    }
	    j+=1;
	    i=0;
	    System.out.println();
	}
	return;
    }
    public static void main(String[] args){
	System.out.println("Enter the number of stages for building a triangle");
	Scanner scan=new Scanner(System.in);
	int stages=scan.nextInt();
	print_func(stages);
    }
}
