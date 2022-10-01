import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
    
		Scanner in = new Scanner(System.in);
		
		int h = in.nextInt();
		int m = in.nextInt();
		in.close();
		
		if(m < 45) {
			h--;
			m += 15;
			if(h < 0) {
				h = 23;
			}
			System.out.println(h + " " + m);
		}
		else {
			System.out.println(h + " " + (m - 45));
		}
	}
}
