package done;
import java.io.DataInputStream;
import java.io.InputStream;

public class FASHION {
    static int partition(int A[], int p, int r) {
        int i = p - 1;
        int key = A[r];
        for (int j = p; j < r; j++) {
            if (A[j] < key) {
                i++;
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        A[r] = A[i + 1];
        A[i + 1] = key;
        return i + 1;
    }

    static void quickSort(int[] A, int p, int r) {
        if (p == r || (p > r))
            return;
        int q = partition(A, p, r);
        quickSort(A, p, q - 1);
        quickSort(A, q + 1, r);
    }

    
    public static void main(String [] args) {
        StdIn s = new StdIn(System.in);
        int T = s.nextInt();
        while(T-->0) {
            int n =  s.nextInt();
            int [] a = new int[n];
            int [] b = new int [n];
            for(int i=0;i<n;i++) {
                a[i]=s.nextInt();
            } 
            for(int i=0;i<n;i++) {
                b[i]=s.nextInt();
            }
            quickSort(a, 0, n-1);
            quickSort(b, 0, n-1);
            int sum=0;
            for(int i=0;i<n;i++) {
                sum+=a[i]*b[i];
            }
            System.out.println(sum);
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
