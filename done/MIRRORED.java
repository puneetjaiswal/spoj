package done;
import java.util.Scanner;


public class MIRRORED {

    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ready");
        while(s.hasNext()) {
            String str = s.nextLine();
            if(str.equals("  ")) break;
            str=str.trim();
            if(str.length()!=2) continue; 
            char c = str.charAt(0);
            char d = str.charAt(1);
            if(c==d) {
                System.out.println("Ordinary pair");
            } else {
                if((c=='p' && d=='q') || (c=='q' && d=='p') || (c=='d' && d=='b') || (c=='b' && d=='d')) {
                    System.out.println("Mirrored pair");
                }  
                else {
                    System.out.println("Ordinary pair");
                }
            }
        }
    }
    
}
