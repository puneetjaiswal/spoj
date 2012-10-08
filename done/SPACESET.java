package done;
import java.io.DataInputStream;
import java.io.InputStream;


public class SPACESET {
    static int MOD = 12345678;

    private static long power(int base, int exponent, int mod) {
        if (exponent == 0)
            return 1;
        long power = power(base, exponent >> 1, mod);
        power *= power;
        power %= mod;
        if ((exponent & 1) != 0) {
            power *= base;
            power %= mod;
        }
        return power;
    }
private static   void solve(int levelsCount, int planetsPerLevel, int pathLength) {
      int edgesPerPlanet = Math.max(1, Math.min(2, planetsPerLevel - 1)) + Math.min(levelsCount - 1, 2) * planetsPerLevel;
    long pathCount = planetsPerLevel;
    pathCount *= levelsCount;
    pathCount %= MOD;
    pathCount *= power(edgesPerPlanet, pathLength - 1, MOD);
    pathCount %= MOD;
    System.out.println(pathCount);
}
    
  public static void main(String [ ]args) {
      StdIn s = new StdIn(System.in);
      int T= s.nextInt();
      while(T-->0) {
          int m=s.nextInt();
          int n = s.nextInt();
          int k =s.nextInt();
          solve(m, n, k);
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
