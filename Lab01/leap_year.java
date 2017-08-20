/** This program tests whether or not a given year is a Leap Year. The user will give input as a command line parameter, and then print out whether or not the date is a valid date, e.g.
$ java LeapYear 2000
2000 is a leap year.
$ java LeapYear 1999
1999 is not a leap year.
$ java LeapYear 2004
2004 is a leap year.
$ java LeapYear 2100
2100 is not a leap year.
*/
import java.util.Scanner;
public class leap_year{
    public static boolean func_leap_year(int year){
	if (year%4==0 && year%100!=0){
	    return true;
	}
	else if (year%400==0){
	    return true;
	}
	else{
	    return false;}
    }
    public static void main(String[] args){
	System.out.println("Enter year to check if it's a leap year or not");
	Scanner scan = new Scanner(System.in);
	int year_entered=scan.nextInt();
	if (leap_year.func_leap_year(year_entered)==true){
	    System.out.println(year_entered+" "+"is a leap year.");}
	else{
	    System.out.println(year_entered+" "+"is not a leap year.");}
	}
    }


