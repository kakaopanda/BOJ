import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());		
		int N = Integer.parseInt(st.nextToken());
		for(int i=M; i<=N; i++) {
			if(isPrime(i)) {
				sb.append(i+"\n");
			}
		}
		System.out.println(sb);
	}
	
	static boolean isPrime(int number) {
		if(number==1) {
			return false;
		}
		for(int i=2; i*i<=number; i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
}
