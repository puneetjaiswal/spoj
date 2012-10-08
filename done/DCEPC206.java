package done;
import java.io.DataInputStream;
import java.io.InputStream;

public class DCEPC206 {

   static int n;
   static    long res = 0;
   static    int max=100001;
   static    int [] temp = new int [max];
   static    int [] arr = new int [max];
   static    void merge(int left, int m, int right)
    {
        int k = 0;
        int i = left, j = m + 1;
        while (i <= m && j <= right) {
            if (arr[i] < arr[j])
            {
                temp[k++] = arr[i];
                res += (long)(right - j + 1) * arr[i++];
            }
            else
                temp[k++] = arr[j++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        while (i <= m) {
            temp[k++] = arr[i++];
        }
        for (int p = 0; p < k; ++p)
            arr[left + p] = temp[p];
    }

   static void sort(int left, int right)
    {
        if (left < right)
        {
            int m = left + (right - left) / 2;
            sort(left, m);
            sort(m + 1, right);
            merge(left, m, right);
        }
    }
    
    public static void main(String [] args) {
        StdIn s = new StdIn(System.in);
        int T = s.nextInt();
        while(T-- >0) {
            int n = s.nextInt();
            
            for(int i=0;i<n;i++) {
                arr[i] =s.nextInt();
            }
            res=0;
            sort(0, n - 1);
            System.out.println(res);
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
        private byte read(){if(bufferPointer == bytesRead)fillBuffer();return buffer[bufferPointer++];}
        public String nextString()  { StringBuffer sb = new StringBuffer("");byte c = read();while (c <= ' ')c = read();do {sb.append((char) c);c = read();} while (c > ' ');return sb.toString();}}

}
