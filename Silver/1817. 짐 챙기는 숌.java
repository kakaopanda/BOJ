import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		
		int box = 0;
		int count = 0;
		
		for(int i=0; i<N; i++) {
			int input = s.nextInt();
			
			// 첫 번째 상자인 경우, 해당 책을 상자에 담기만 한다.
			if(i==0) {
				box += input;
				count++;
				continue;
			}
			
			// 두 번째 상자부터는 담을 책의 무게를 기존 상자의 무게와 더해, 담을 수 있는지 판단한다.
			// 최대 무게를 초과하는 경우, 새로운 상자를 가져와 담는다.
			if(box+input>M) {
				count++;
				box = input;
			}
			
			// 최대 무게를 초과하지 않는 경우, 기존 상자에 담는다.
			else {
				box += input;
			}
		}
		System.out.println(count);
	}
}
