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
	
		int input = Integer.parseInt(st.nextToken());
		BigInteger N = new BigInteger(input+"");
		
		input = Integer.parseInt(st.nextToken());
		BigInteger M = new BigInteger(input+"");
		
		sb.append(combination(M,N)+"\n");
		System.out.println(sb);
	}
	static BigInteger combination(BigInteger n, BigInteger m) {
		// mCn 으로 가정한다. (m>=n)
		return factorial(m).divide((factorial(n).multiply(factorial(m.subtract(n)))));
	}
	static BigInteger factorial(BigInteger n) {
		if(n.longValue()<=1) {
			return new BigInteger("1");
		}
		else {
			return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
		}
	}
}
