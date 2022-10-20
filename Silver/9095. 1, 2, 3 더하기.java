import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int input[] = {1,2,3};
	static int N;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			answer = 0;
			perm(0, 0);
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
	static void perm(int cnt, int sum) {
		// perm()을 수행하는 최대 횟수는 1을 N번만큼 더한 것이다.
		if(cnt>N) {
			return;
		}
		if(sum==N) {
			answer++;
			return;
		}
		else {
			for(int i=0; i<input.length; i++) {
				perm(cnt+1, sum+input[i]);
			}
		}
	}
}
