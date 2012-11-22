package done;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class MCOINS {
static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    @SuppressWarnings("unused")
    private static int totalWays(int N, int K, int L, int level) {
        if(map.get(N) != null) return map.get(N);
        int total = 0;
        if(N<0) return 0;
        if(N==1 || N==K || N==L) {
            total=1;
            if(level%2==0) {}
            else {}
        }
        total += totalWays(N-1, K, L, level+1);
        total += totalWays(N-K, K, L, level+1);
        total += totalWays(N-L, K, L, level+1);
        map.put(N, total);
        return total;
    }
    public static void main(String [] args) {
        StdIn s = new StdIn(System.in);
        int k = s.nextInt();
        int l = s.nextInt();
        int m = s.nextInt();
        boolean[] win = new boolean[1000001];
        for (int i = 1; i <= 1000000; i++) {
            win[i] = !win[i - 1];
            if (i >= k && !win[i - k])
                    win[i] = true;
            if (i >= l && !win[i - l])
                    win[i] = true;
        }
        for (int i = 0; i < m; i++)
            System.out.print(win[s.nextInt()] ? 'A' : 'B');
        System.out.println();  
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
        private byte read() {if(bufferPointer == bytesRead)fillBuffer();return buffer[bufferPointer++];}}
}
