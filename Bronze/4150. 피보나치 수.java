import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		System.out.println(fibo(N).toString());
	}
	static BigInteger fibo(int n) {
		BigInteger a = BigInteger.valueOf(1); // fibo(1)
		BigInteger b = BigInteger.valueOf(1); // fibo(2)
		BigInteger c = a.add(b);
		if(n<=2) {
			return a;
		}
		for(int i=2; i<n; i++) {
			c = a.add(b); // fibo(3)
			a = b;
			b = c;
		}
		return c;
	}
}
