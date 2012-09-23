package done;
import java.io.DataInputStream;
import java.io.InputStream;


public class TEST {

    public static void main (String p[ ]) throws Exception {
        int sum = 0;
        for(int i=0;i<100000000;i++) {
            sum++;
        }
//        Parserdoubt1 ps = new Parserdoubt1(System.in);
//        String t = ps.nextString();
//        while(!t.equals("42")) {
//            System.out.println(t);
//            t = ps.nextString();
//        }
    }
}

class Parserdoubt1 {
    final private int BUFFER_SIZE = 1 << 17;

    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Parserdoubt1(InputStream in) {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String nextString() throws Exception {
        StringBuffer sb = new StringBuffer("");
        byte c = read();
        while (c <= ' ')
            c = read();
        do {
            sb.append((char) c);
            c = read();
        } while (c > ' ');
        return sb.toString();
    }

    public char nextChar() throws Exception {
        byte c = read();
        while (c <= ' ')
            c = read();
        return (char) c;
    }

    public int nextInt() throws Exception {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = c == '-';
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws Exception {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = c == '-';
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws Exception {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws Exception {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
}