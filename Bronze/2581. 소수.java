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
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int min = N, sum = 0, count = 0;
		
		for(int i=M; i<=N; i++) {
			if(isPrime(i)) {
				count++;
				sum += i;
				if(min > i) {
					min = i;
				}
			}
		}
		if(count!=0) {
			sb.append(sum+"\n");
			sb.append(min+"\n");
		}
		else {
			sb.append(-1);
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
