import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		
		int max = (x>y ? x : y);
		int min = (x<y ? x : y);
		int factor = 0;
		int multiple = 0;
		
		// 최대 공약수 계산
		for(int i=1; i<=min; i++) {
			if((max%i==0)&&(min%i==0)) {
				factor = i;
			}
		}
		
		// 최소 공배수 계산
		for(int i=1; i<=max*min; i++) {
			if((i%max==0)&&(i%min==0)) {
				multiple = i;
				break;
			}
		}
		
		System.out.println(factor);
		System.out.println(multiple);
	}
}
