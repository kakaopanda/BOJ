import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int count = 0;
		for(int i=0; i<N; i++) {
			count += check(s.nextInt());
		}
		System.out.println(count);
		
	}
	static int check(int n) {
		boolean b = true;
		// 1은 소수가 아니다.
		if(n==1)
			return 0;
		else {
			for(int i=2; i<n-1; i++) {
				if(n%i==0)
					b = false;
			}
			if(b) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
}
