import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		int C = s.nextInt();
		
		int plus = 0;
		int minute = C+B;
		while(minute>=60) {
			minute-=60;
			plus++;
		}
		int hour = A+plus;
		if(hour>=24) {
			hour -= 24;
		}
		System.out.println(hour+" "+minute);
	}
}