import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();

		BigInteger A = new BigInteger(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		BigInteger B = new BigInteger(st.nextToken());
		
		// K가 6이고, N이 4일 때 전체 개수 A와 두 사람이 가진 사과 개수의 차이 B는 다음과 같다.
		// A = K+N = 10
		// B = K-N = 2
		// K = (A+B)/2 = 6 
		// N = K-B = 4
		System.out.println((A.add(B).divide(new BigInteger("2"))));
		System.out.println((A.add(B)).divide(new BigInteger("2")).subtract(B));
	}
}
