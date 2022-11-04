import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		final int mod = 10007;
		int array[] = new int[1000];
		array[0] = 1;
		array[1] = 3;
		// array[2] = 1*2+3 = 5
		// array[3] = 3*2+5 = 11
		// array[4] = 5*2+11 = 21..
		
		// array[i] = array[i-2]*2 + array[i-1] (i>=2)의 점화식을 갖게 된다.
		for(int i=2; i<1000; i++) {
			array[i] = (array[i-1] + array[i-2]*2)%mod;
		}
		System.out.println(array[n-1]);
	}
}
