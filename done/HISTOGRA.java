package done;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HISTOGRA {

    static long a = 1000000000;

    static long getMaxArea(long[] A) {
        List<Integer> stack = new ArrayList<Integer>();
        int i = 0;
        int top;
        long maxArea = 0, tempAreaTop = 0;
        while (i < A.length) {
//            System.out.println(stack);
            if (stack.size() == 0 || A[stack.get(stack.size() - 1)] <= A[i]) {
                stack.add(i++);
            } else {
                top = stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                tempAreaTop = A[top] * (stack.isEmpty() ? i : i - stack.get(stack.size() - 1) - 1);
                if (tempAreaTop > maxArea) {
                    maxArea = tempAreaTop;
                }
            }
        }
        while (!stack.isEmpty()) {
            top = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            tempAreaTop = A[top] * (stack.isEmpty() ? i : i - stack.get(stack.size() - 1) - 1);
            if (tempAreaTop > maxArea) {
                maxArea = tempAreaTop;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        StdIn s = new StdIn(System.in);
        int n = s.nextInt();
        while (n > 0) {
            long[] A = new long[n];
            for (int i = 0; i < n; i++) {
                A[i] = s.nextInt();
            }
            System.out.println(getMaxArea(A));
            n = s.nextInt();
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
