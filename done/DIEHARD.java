package done;
import java.io.DataInputStream;
import java.io.InputStream;


public class DIEHARD {
    static int ha =3;
    static int aa= 2;
    
  static  int hw =-5;
  static  int aw = -10;
    
   static int hf=-20;
   static int af=5;
    
   static int max=0;
    static void compute(int H, int A, int count, boolean state) {
        if(H<=0|| A<=0) return;
        if(count>max) max=count;
        if(state) {
            compute(H+ha, A+aa, count+1, false);
        } 
        else {
            if(H+hw >0 && A+aw >0)
            compute(H+hw, A+aw, count+1, true);
            else if(H+hf>0)
            compute(H+hf, A+af, count+1, true);
        }
    }
    public static void main(String [] args) {
        StdIn s = new StdIn(System.in);
        int T =s.nextInt();
        
        while(T-->0) {
            max=0;
            int H=s.nextInt();
            int A=s.nextInt();
            
            H+=ha;
            A +=aa;
            compute(H, A, 1, false);
            System.out.println(max);
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
