package done;
import java.io.DataInputStream;
import java.io.InputStream;


public class SPEED {

    static int gcd(int a, int b) {
        if(a==1||b==1) return 1;
        if(a==b) return a;
        else if(a>b) {
            if(a%b==0) return b;
            return gcd(a%b,b);
        } 
        else {
            if(b%a==0) return a;
            return gcd(a,b%a);
        }
    }
    
    public static void main(String [] args) {
        StdIn s = new StdIn(System.in);
        int T= s.nextInt();
        while(T-->0) {
            int u=s.nextInt();
            int v=s.nextInt();
            int effspd = Math.abs(u-v);
            int gcd=gcd(Math.abs(u),Math.abs(v));
            System.out.println(effspd/gcd);
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
