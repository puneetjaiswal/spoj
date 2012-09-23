package done;
import java.io.DataInputStream;
import java.io.InputStream;
public class ACMPRAC1 {

    public static void main(String [] args){
        StdIn s = new StdIn(System.in);
        int T= s.nextInt();
        int count=0;
        while(count <T) {
            int N=s.nextInt();
            int lastX=0;int lastY=0;
            double maxVal=0;
            for(int i=0;i<N;i++) {
                int x = s.nextInt();
                int y=s.nextInt();
                double log = y * Math.log10(x);
                if(log>maxVal) {
                    maxVal=log;
                    lastX=x;
                    lastY=y;
                }
            }
            System.out.println(lastX+" "+lastY);
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
        public char nextChar() {byte c = read();while (c <= ' ')c = read();return (char) c;}
        public int nextInt() {int ret = 0;byte c = read();while (c <= ' ')c = read();boolean neg = c == '-';if (neg)c=read();do{ret=ret*10+c-'0';c = read();} while (c>' ');if(neg)return -ret;return ret;}
        private void fillBuffer(){try{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);}catch(Exception e) {}if(bytesRead==-1)buffer[0]=-1;}
        private byte read(){if(bufferPointer == bytesRead)fillBuffer();return buffer[bufferPointer++];}}
}
