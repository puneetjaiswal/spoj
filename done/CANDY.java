package done;
import java.io.DataInputStream;
import java.io.InputStream;

public class CANDY {
    public static void main(String [] args) {
        StdIn s = new StdIn(System.in);
        int N = s.nextInt();
        while(N!=-1) {
            int tc =0;
            int A [] = new int [N];
            for(int i=0;i<N;i++) {
                A[i]=s.nextInt();
                tc+=A[i];
            }
            int avg = tc/N;
            if(avg*N==tc) {
                int numMoves =0;
                for(int i=0;i<N;i++) {
                    if(A[i]>avg) {
                        numMoves+=A[i]-avg;
                    }
                }
                System.out.println(numMoves);
            }
            else {
                System.out.println("-1");
            }
            N = s.nextInt();
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
        private byte read(){if(bufferPointer == bytesRead)fillBuffer();return buffer[bufferPointer++];}}
}
