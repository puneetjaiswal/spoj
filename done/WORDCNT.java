package done;
import java.util.Scanner;


public class WORDCNT {
public static void main (String [] args) {
    Scanner scn = new Scanner (System.in);
    int N =Integer.parseInt(scn.nextLine());
    int count=0;
    while(count<N) {
        String line = scn.nextLine();
//        System.out.println(line);
        String [] arr = line.trim().split("\\s+");
        int [] aux = new int [arr.length];
        aux[0]=1;
        int max=1;
        for(int i=1;i<arr.length;i++) {
            if(arr[i].length()==arr[i-1].length()) {
                aux[i]=aux[i-1]+1;
            }
            else {
                aux[i]=1;
            }
            if(aux[i]>max) {
                max=aux[i];

            }
          //  System.out.print(aux[i]);
        }
     //   System.out.println();
        System.out.println(max);
        count++;
    }
    
}
}
