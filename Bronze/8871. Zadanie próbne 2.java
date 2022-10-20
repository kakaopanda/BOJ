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

		int N = Integer.parseInt(st.nextToken());
		
		// 최소 라운드수는 시험 라운드를 포함한 라운드 수에 2를 곱한 값이고, 최대 라운드 수는 3을 곱한 값이다.
		System.out.println((N+1)*2+" "+(N+1)*3);
	}
}
