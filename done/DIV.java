package done;

public class DIV {
    private static int MAX = 1000000, LMT = 1000;
    private static int small [] = new int [MAX+10];

    private static void smallest() {
        int i, j;
        for(i=2; i<=MAX; i++) small[i] = ((i&1)==0)? 2 : i;
        for(i=3; i<=LMT; i+=2)
            if(small[i]==i)
                for(j=i; j<=MAX; j+=i)
                    if(small[j]==j)
                        small[j] = i;
    }

  private static  int dn(int n) {
        int prv=0, cnt=0, res=1;
        while(n>1) {
            if(small[n]!=prv) {
                res *= (cnt+1);
                prv = small[n];
                cnt = 1;
            }
            else cnt++;
            n /= small[n];
        }
        return res*(cnt+1);
    }

    public static void main( String  []args) {
        smallest();
        int d, i, p, q, cnt=0;
        for(i=2; i<=MAX; i++) {
            d = dn(i);
            p = small[d];
            if(p==d) continue;
            q = small[d/p];
            if(q==p || q!=d/p) continue;
            cnt++;
            if(cnt%9==0) System.out.println(i);
        }
    }
}
