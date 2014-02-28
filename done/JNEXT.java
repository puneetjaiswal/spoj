package done;
import java.io.DataInputStream;
import java.io.InputStream;

public class JNEXT {

    static void countingSortForDigits(int [] A, int start, int end) {
        int [] B = new int [10];
        for(int i=start;i<=end;i++) {
            B[A[i]]+=1;
        }
        int s=start;
        for(int i=0;i<10;i++) {
            int val=B[i];
            while(val-->0) {
                A[s++] = i;
            }
        }
    }
    
    public static void main(String [] args) {
        StdIn s = new StdIn(System.in);
        int T = s.nextInt(); 
        while(T-->0) {
            int n = s.nextInt();
            int [] a = new int [n];
            int bp=-1;
            a[0]=s.nextInt();
            int lastBiggerThanBP = 0;
            for(int i=1;i<n;i++) {
                a[i]=s.nextInt();
                if(bp!=-1 && a[i] < a[lastBiggerThanBP] && a[i] > a[bp]) {
                    lastBiggerThanBP = i;
                }
                if(a[i] > a[i-1]) {
                    bp=i-1;
                    lastBiggerThanBP=i;
                }
            }
            
            if(bp!=-1) {
                int temp = a[bp];
                a[bp] = a[lastBiggerThanBP];
                a[lastBiggerThanBP] = temp;
                countingSortForDigits(a, bp+1, n-1);
                StringBuffer sb = new StringBuffer();
                for(int i=0;i<n;i++) {
                    sb.append(a[i]);
                }
                System.out.println(sb.toString());
            }
            else {
                System.out.println(-1);
            }
        }
    }
    
    private static class StdIn {
        final private int BUFFER_SIZE = 1 << 17;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public StdIn(InputStream in) {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
        }
        public int nextInt() {int ret = 0;byte c = read();while (c <= ' ')c = read();boolean neg = c == '-';if (neg)c=read();do{ret=ret*10+c-'0';c = read();} while (c>' ');if(neg)return -ret;return ret;}
        private void fillBuffer(){try{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);}catch(Exception e) {}if(bytesRead==-1)buffer[0]=-1;}
        private byte read(){if(bufferPointer == bytesRead)fillBuffer();return buffer[bufferPointer++];}
    }
}
