package done;
import java.io.DataInputStream;
import java.io.InputStream;

public class NOCHANGE {
   
    private static   void solve(int [] A, int x) {
        for (int i = 1; i < A.length; i++)
                A[i] += A[i - 1];
        boolean[] reachable = new boolean[x + 1];
        reachable[0] = true;
        for (int denomination : A) {
                for (int i = denomination; i <= x; i++)
                        reachable[i] |= reachable[i - denomination];
        }
        System.out.println(reachable[x] ? "YES" : "NO");
}
    public static void main(String  [] args) {
        StdIn s = new StdIn(System.in);
        int x= s.nextInt();
        int k = s.nextInt();
        int [] A = new int [k];
        for(int i=0;i<k;i++) {
            A[i]  = s.nextInt();
        }
        solve(A, x);
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