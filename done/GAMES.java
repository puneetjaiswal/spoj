package done;
import java.io.DataInputStream;
import java.io.InputStream;


public class GAMES {
    private static int findTwos(int num, int count) {
        if(num%2==0) {
            return findTwos(num/2, count+1);
        } 
        else 
        return count;
    }

    private static int findFives(int num, int count) {
        if(num %5 ==0) 
            return findFives(num/5, count+1);
        else
        return count;
    }
    private static String trimZeroesFromLast(String str) {
        if("".equals(str)) return str;
        if(str.charAt(str.length()-1) != '0') {
            return str;
        }
        else {
            if(str.length()==1) return "";
            return trimZeroesFromLast(str.substring(0,str.length()-1));
        }
    }
    public static void main(String[] args) {
        StdIn s = new StdIn(System.in);
        int T = s.nextInt();
        while (T-- > 0) {
            String str = s.nextString();
            String[] split = str.split("\\.");
            if (split.length < 2) {
                System.out.println(1);
            } else {
                String str1 = split[1];
                str1= trimZeroesFromLast(str1);
                if("".equals(str1) ) {
                    System.out.println(1);
                    continue;
                }
                int dec = Integer.parseInt(str1);
                int twos =0;
                int fives=0;
                if(dec %2==0) {
                    twos = findTwos(dec,0);
                } 
                if(dec%5==0) {
                    fives = findFives(dec,0);
                }
                if(twos==0 && fives == 0) {
                    System.out.println((int)Math.pow(10, str1.length()));
                } else {
                    int base=1;
                    int exp=1;
                    if(twos>0) {
                        base=5;
                        exp=twos;
                    }
                    else {
                        base=2;
                        exp=fives;
                    }
                    if(exp >= str1.length()) {
                        System.out.println((int) Math.pow(base, str1.length()));
                    } else {
                        System.out.println((int)(Math.pow(base, exp) * Math.pow(10, str1.length()-exp)));                        
                    }
                }
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
        public int nextInt() {int ret = 0;byte c = read();while (c <= ' ')c = read();boolean neg = c == '-';if (neg)c=read();do{ret=ret*10+c-'0';c = read();} while (c>' ');if(neg)return -ret;return ret;}
        private void fillBuffer(){try{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);}catch(Exception e) {}if(bytesRead==-1)buffer[0]=-1;}
        private byte read(){if(bufferPointer == bytesRead)fillBuffer();return buffer[bufferPointer++];}
        public String nextString()  { StringBuffer sb = new StringBuffer("");byte c = read();while (c <= ' ')c = read();do {sb.append((char) c);c = read();} while (c > ' ');return sb.toString();}}

}
