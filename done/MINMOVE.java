package done;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class MINMOVE {
    private static int minMove(String s) {
        int i = 0;
        int j = 1;
        int k = 1;
        int p = 1;
        while (j + k <= s.length() * 2) {
                char a = s.charAt((i + k - 1) % s.length());
                char b = s.charAt((j + k - 1) % s.length());
                if (a > b) {
                        i = j++;
                        k = p = 1;
                } else if (a < b) {
                        j += k;
                        k = 1;
                        p = j - i;
                } else if (a == b && k != p) {
                        k++;
                } else {
                        j += p;
                        k = 1;
                }
        }
        return i;  
    }
    public static void main(String  [] args) {
        InputReader in = new InputReader(System.in);
        String s = in.readString();
        System.out.println(minMove(s));
    }
   private static class InputReader {
       InputStream stream;
       byte[] buf = new byte[1024];
       int curChar, numChars;

       InputReader(InputStream stream) {
               this.stream = stream;
       }

       int read() {
               if (numChars == -1)
                       throw new InputMismatchException();
               if (curChar >= numChars) {
                       curChar = 0;
                       try {
                               numChars = stream.read(buf);
                       } catch (IOException e) {
                               throw new InputMismatchException();
                       }
                       if (numChars <= 0)
                               return -1;
               }
               return buf[curChar++];
       }

       int readInt() {
               int c = read();
               while (isSpaceChar(c))
                       c = read();
               int sgn = 1;
               if (c == '-') {
                       sgn = -1;
                       c = read();
               }
               int res = 0;
               do {
                       if (c < '0' || c > '9')
                               throw new InputMismatchException();
                       res *= 10;
                       res += c - '0';
                       c = read();
               } while (!isSpaceChar(c));
               return res * sgn;
       }

       long readLong() {
               int c = read();
               while (isSpaceChar(c))
                       c = read();
               int sgn = 1;
               if (c == '-') {
                       sgn = -1;
                       c = read();
               }
               long res = 0;
               do {
                       if (c < '0' || c > '9')
                               throw new InputMismatchException();
                       res *= 10;
                       res += c - '0';
                       c = read();
               } while (!isSpaceChar(c));
               return res * sgn;
       }

       String readString() {
               int c = read();
               while (isSpaceChar(c))
                       c = read();
               StringBuffer res = new StringBuffer();
               do {
                       res.appendCodePoint(c);
                       c = read();
               } while (!isSpaceChar(c));
               return res.toString();
       }

       boolean isSpaceChar(int c) {
               return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
       }

       String readLine0() {
               StringBuffer buf = new StringBuffer();
               int c = read();
               while (c != '\n' && c != -1) {
                       if (c != '\r')
                               buf.appendCodePoint(c);
                       c = read();
               }
               return buf.toString();
       }

       String readLine() {
               String s = readLine0();
               while (s.trim().length() == 0)
                       s = readLine0();
               return s;
       }

       String readLine(boolean ignoreEmptyLines) {
               if (ignoreEmptyLines)
                       return readLine();
               else
                       return readLine0();
       }
       char readCharacter() {
               int c = read();
               while (isSpaceChar(c))
                       c = read();
               return (char) c;
       }

       double readDouble() {
               int c = read();
               while (isSpaceChar(c))
                       c = read();
               int sgn = 1;
               if (c == '-') {
                       sgn = -1;
                       c = read();
               }
               double res = 0;
               while (!isSpaceChar(c) && c != '.') {
                       if (c == 'e' || c == 'E')
                               return res * Math.pow(10, readInt());
                       if (c < '0' || c > '9')
                               throw new InputMismatchException();
                       res *= 10;
                       res += c - '0';
                       c = read();
               }
               if (c == '.') {
                       c = read();
                       double m = 1;
                       while (!isSpaceChar(c)) {
                               if (c == 'e' || c == 'E')
                                       return res * Math.pow(10, readInt());
                               if (c < '0' || c > '9')
                                       throw new InputMismatchException();
                               m /= 10;
                               res += (c - '0') * m;
                               c = read();
                       }
               }
               return res * sgn;
       }
}

}
