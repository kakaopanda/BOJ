import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		System.out.println(sieve(N,K));
	}
	static int sieve(int n, int k) {
		int array[] = new int[n+1];
		int count = 0;
		for(int i=2; i<=n; i++) {
			for(int j=i; j<=n; j+=i) {
				if(array[j]==0) {
					array[j] = 1;
					count++;
					if(count==k) {
						return j;
					}
				}
			}
		}
		return 0;
	}
}
