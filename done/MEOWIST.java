package done;
import java.util.Scanner;

public class MEOWIST {
    private static int partition(data [] a, int p, int r) {
        if(p==r) return r;  
        data key = a[r];
        int i=p-1;
        for(int j=p;j<r;j++) {
            if(a[j].compareTo(key) >0) {
                i++;
                data temp = a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        a[r]=a[i+1];
        a[i+1]=key;
    return i+1;
    }
    private static void quickSort(data [] a,int p, int r) {
        if(r<=p) return;
        int q =partition(a, p, r);
        quickSort(a, p, q-1);
        quickSort(a, q+1, r);
    }
    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        data [] darr = new data [10000];
        int i=0;
        while(s.hasNext()) {
            data t = new data(s.next().trim(), s.nextInt());
            darr[i++] =t;
        }
        quickSort(darr, 0, i-1);
        for(int j=0;j<i;j++) {
            System.out.println(darr[j].str);
        }
    }
    
    private static class data{
        public data(String s, int n) {
            this.str=s;
            this.num=n;
        }
        String str;
        int num;
        boolean equals(data d)  {
            if (this.str.equals(d.str) && this.num==d.num) return true;
            return false;
        }
        int compareTo (data d) {
            if(this.num > d.num) {
                return 1;
            }
            else if(this.num < d.num) return -1;
            else {
                return d.str.compareTo(this.str);
            }
        }
    }
    
}
