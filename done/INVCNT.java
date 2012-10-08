package done;
import java.io.DataInputStream;
import java.io.InputStream;


public class INVCNT {

    static long tc=0;
    
    static long[] merge(long[] A, long[] B) {
        int t = A.length + B.length;
        long[] C = new long[t];
        int i = 0, j = 0, count = 0;
        while (count < t) {
            if (i < A.length && j < B.length) {
                if (A[i] <= B[j]) {
                    C[count++] = A[i++];
                } else {
                    long temp = B[j];
                    C[count++] = B[j++];
                    tc=tc+A.length-i;
                }
            } else {
                if(i==A.length && count < t) {
                    C[count++] = B[j++];
                } else if(j==B.length && count <t) {
                    C[count++] = A[i++];
                }
            }
        }
        return C;
    }

     static long [] mergeSort(long[] A, int p, int r) {
       if(p==r) {
           long B [] = new long [1];
           B[0] = A[p];
           return B;
       }
       int mid=(r+p)/2;
       long [] m = mergeSort(A, p, mid);
       long [] n = mergeSort(A, mid+1, r);
       return merge(m, n);
    }
    
    public static void main(String [] args) {
        StdIn s = new StdIn(System.in);
        int T = s.nextInt();
        while(T-- >0) {
            int n = s.nextInt();
            long A[] = new long [n];
            for(int i=0;i<n;i++) {
                A[i] =s.nextInt();
            }
            tc=0;
            mergeSort(A, 0, n-1);
            System.out.println(tc);
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
        public char nextChar() {byte c = read();while (c <= ' ')c = read();return (char) c;}
        public int nextInt() {int ret = 0;byte c = read();while (c <= ' ')c = read();boolean neg = c == '-';if (neg)c=read();do{ret=ret*10+c-'0';c = read();} while (c>' ');if(neg)return -ret;return ret;}
        private void fillBuffer(){try{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);}catch(Exception e) {}if(bytesRead==-1)buffer[0]=-1;}
        private byte read(){if(bufferPointer == bytesRead)fillBuffer();return buffer[bufferPointer++];}
        public String nextString()  { StringBuffer sb = new StringBuffer("");byte c = read();while (c <= ' ')c = read();do {sb.append((char) c);c = read();} while (c > ' ');return sb.toString();}}

}
