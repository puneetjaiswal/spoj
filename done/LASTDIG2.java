package done;
import java.math.BigInteger;
import java.util.Scanner;
public class LASTDIG2 {static BigInteger m=new BigInteger("2");static BigInteger n=new BigInteger("1");static int g(int o,String p,int u){
if(p.equals("1"))return o%10;BigInteger q=new BigInteger(p);int r=p.charAt(p.length()-1)-'0';if(r%2==0){o=(o*o)%10;q=q.divide(m);return g(o,q.toString(),u);}else{q=q.subtract(n);return o*g(o,q.toString(),u)%10;}}public static void main(String[]a){
Scanner s=new Scanner(System.in);s.next();while(s.hasNext()){String s1=s.next();String s2=s.next();int u=s1.charAt(s1.length()-1)-(int)'0';
if(s2.equals("0"))System.out.println(1);else if(u==0)System.out.println(0);else{System.out.println(g(u,s2,u));}}}}
