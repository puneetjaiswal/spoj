package done;
import java.io.DataInputStream;
import java.io.InputStream;

public class MAXLN {
    public static void main(String [] args) {
        StdIn s = new StdIn(System.in);
        int T=s.nextInt();
        int count=0;
        while(T-->0) {
            long n = s.nextInt();
            System.out.println("Case "+(++count)+": "+((long)4*n*n)+".25");
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
