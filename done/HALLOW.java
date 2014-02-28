package done;
import java.io.DataInputStream;
import java.io.InputStream;

public class HALLOW {
    public static void main(String [] args) {
        StdIn s = new StdIn(System.in);
        int c=s.nextInt();
        int n=s.nextInt();
        int i=0;
        while(c>0 && n >0) {
            int a[] = new int[n+1];
            int k=120000;
            int flag[] = new int[k];
            int aux[] = new int[k];
            int total=0;
            int up = 0,low = 0;
            flag[0]=1;
            for(i=1;i<n+1;i++) {
                a[i]=s.nextInt();
            }
            for(i=1;i<n+1;i++) {
                total+=a[i];
                total%=c;
                if(flag[total] >0) {
                    if(i-aux[total] < k) {
                        k=aux[total];
                        low=aux[total]+1;
                        up=i;
                    }
                }
                aux[total] =i;
                flag[total] =1;
            }
            for(i=low;i<up;i++) {
                System.out.print(i+" ");
            }
            System.out.println(i);
            c=s.nextInt();
            n=s.nextInt();
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
