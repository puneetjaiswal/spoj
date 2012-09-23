package done;
import java.math.BigInteger;
import java.util.Scanner;


public class JULKA {
    static BigInteger two = new BigInteger("2");
public static void main(String [] args) {
Scanner scn = new Scanner(System.in);
while(scn.hasNext()) {
    BigInteger total = new BigInteger(scn.next());
    BigInteger diff = new BigInteger(scn.next());
    BigInteger x = total.add(diff).divide(two);
    System.out.println(x);
    System.out.println(x.subtract(diff));
}
}
}
