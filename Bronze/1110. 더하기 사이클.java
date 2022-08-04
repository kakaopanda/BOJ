import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		if(N<0 || N>99)
			return;
		int cycle = 0;
		int number = N;
		do {
			int first = 0, second = 0, sum = 0;
			if(number<10) { // 입력받은 수에서 첫 번째 자릿수 추출
				first = 0;
				second = number;
			}
			else { // 입력받은 수에서 두 번째 자릿수 추출
				first = number/10;
				number %= 10;
				second = number;
			}
			sum = first + second; // 입력받은 수의 첫 번째 수와 두 번째 수를 더한 값
			if(sum>=10)
				sum%=10;
			number = second*10+sum; // 새로운 수 계산
			cycle++;
		}while(number!=N);
		System.out.println(cycle);
	}
}