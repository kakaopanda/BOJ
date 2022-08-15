import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int i=0; i<T; i++) {
			int A = s.nextInt();
			int B = s.nextInt();
			int min = (A<B ? A : B);
			int max = (A>B ? A : B);
			
			int multiple = 0;
			do {
				multiple += min;
				if(multiple%max==0)
					break;
			}while(true);
			System.out.println(multiple);
		}
	}
}
