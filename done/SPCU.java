package done;
import java.io.DataInputStream;
import java.io.InputStream;

public class SPCU {

    private static boolean validate(int[] A) {
        int N = A.length;
        if (A[0] > 0) {
            return false;
        }
        for (int i = 1; i < N; i++) {
            if (A[i] > i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StdIn s = new StdIn(System.in);
        int T = s.nextInt();
        while (T-- > 0) {
            int N = s.nextInt();
            int A[] = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = s.nextInt();
            }
            if (validate(A)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
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

        public int nextInt() {
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

        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            } catch (Exception e) {
            }
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}
