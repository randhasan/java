/*
@Rand Hasan Student, Period 11
8/28/2019
House.java Ch2 Output, Problem 3: Class Schedule
Program that uses zone formatting to
output my class schedule.
*/

public class Schedule {
    public static void main(String[] args) {
        System.out.print("A-Days\n");
        System.out.printf("%-10s%-20s%20s\n","Period","Class","Teacher");
        System.out.printf("%-10s%-20s%20s\n","1","Honors Spanish 3","Hough");
        System.out.printf("%-10s%-20s%20s\n","2","Honors Physics","Perry");
        System.out.printf("%-10s%-20s%20s\n","3","Honors Chemistry","Bartoszewicz");
        System.out.printf("%-10s%-20s%20s\n","4","Honors Chemistry","Bartoszewicz");
        System.out.printf("%-10s%-20s%20s\n","5","Lunch","------");
        System.out.printf("%-10s%-20s%20s\n","67","Honors History","Ervin");
        System.out.printf("%-10s%-20s%20s\n","89","Honors English 10","Byko");
        System.out.printf("%-10s%-20s%20s\n","10","Honors Pre-Calculus","Tsambis");
        System.out.printf("%-10s%-20s%20s\n\n","11","AP Computer Science","Klosky");
        
        System.out.print("B-Days\n");
        System.out.printf("%-10s%-20s%20s\n","Period","Class","Teacher");
        System.out.printf("%-10s%-20s%20s\n","1","Honors Spanish 3","Hough");
        System.out.printf("%-10s%-20s%20s\n","2","Honors Physics","Perry");
        System.out.printf("%-10s%-20s%20s\n","3","Honors Physics","Perry");
        System.out.printf("%-10s%-20s%20s\n","4","Honors Chemistry","Bartoszewicz");
        System.out.printf("%-10s%-20s%20s\n","5","Lunch","------");
        System.out.printf("%-10s%-20s%20s\n","67","Honors History","Ervin");
        System.out.printf("%-10s%-20s%20s\n","89","Honors English 10","Byko");
        System.out.printf("%-10s%-20s%20s\n","10","Honors Pre-Calculus","Tsambis");
        System.out.printf("%-10s%-20s%20s\n","11","AP Computer Science","Klosky");
       
    }

}
