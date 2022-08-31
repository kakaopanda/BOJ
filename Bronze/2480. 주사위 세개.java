import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int first = s.nextInt();
		int second = s.nextInt();
		int third = s.nextInt();
		int array[] = new int[3];
		array[0] = first;
		array[1] = second;
		array[2] = third;
		int prize = 0;
		
		// 같은 눈이 3개가 나오는 경우
		if(first==second) {
			if(second==third) {
				prize = 10000 + first*1000;
			}
			// 같은 눈이 2개만 나오는 경우
			else {
				prize = 1000 + first*100;	
			}
		}
		// 같은 눈이 2개만 나오는 경우
		else if(second==third) {
			prize = 1000 + second*100;
		}
		// 같은 눈이 2개만 나오는 경우
		else if(third==first) {
			prize = 1000 + third*100;
		}
		// 모두 다른 눈이 나오는 경우
		else if(first!=second) {
			if(second!=third) {
				Arrays.sort(array);
				prize = array[2] * 100;
			}
		}
		
		System.out.println(prize);
	}
}