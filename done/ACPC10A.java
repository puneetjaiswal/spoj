package done;
import java.util.Scanner;
public class ACPC10A {
 public static void main(String [] args) {
     Scanner scn = new Scanner(System.in);
     while(true) {
         String str = scn.nextLine();
         if(str.equals("0 0 0")) {
             return;
             }
         String [] arr = str.split(" ");
         int a = Integer.parseInt(arr[0]);
         int b = Integer.parseInt(arr[1]);
         int c = Integer.parseInt(arr[2]);
         if(a==b && b==c) {}
         else if(b-a==c-b) {System.out.println("AP "+(c+b-a));}
         else if(c/b==b/a && b!=0 & a!=0) { System.out.println("GP "+(c*(b/a)));}
         else {   
         }
     }
 }
}