package done;
import java.io.DataInputStream;
import java.io.InputStream;
public class FCTRL{
    
    static int zeta(int n) {
        int ret = 0;
        for (int p = 5; p <= n; p*=5)
            ret += n/p;
        return ret;
    }
    
    public static void main(String [] args) throws Exception {
        StdIn stdin = new StdIn(System.in);
        int N = stdin.nextInt();
        int count =0;
        while(count < N) {
            int n = stdin.nextInt();
            System.out.println(zeta(n));
            count++;
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
        public int nextInt() throws Exception {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
        c = read();
        boolean neg = c == '-';
        if (neg)c=read();do{ret=ret*10+c-'0';c = read();} while (c>' ');if(neg)return -ret;return ret;}
        private void fillBuffer() throws Exception{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;}
        private byte read() throws Exception{if(bufferPointer == bytesRead)fillBuffer();return buffer[bufferPointer++];}}
}
