import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int money[] = new int[N];
		int K = s.nextInt();
		for(int i=0; i<N; i++) {
			money[i] = s.nextInt();
		}
		int count = 0;
		for(int i=N-1; i>=0; i--) {
			if(K>=money[i]) {
				count += (K/money[i]);
				K %= money[i];
			}
		}
		System.out.println(count);
	}
}
