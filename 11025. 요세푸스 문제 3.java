import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 시간 및 메모리가 극도로 제한되어 있는 문제로, 수학적인 공식을 이용하지 않으면 풀 수 없다.
// 메모리 제한으로 인해, 스택에 호출이 쌓이는 재귀함수를 이용할 수 없다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 1;
		
		// Func(1,K) = 1이므로, 인덱스는 2부터 시작한다.
		for(int i=2; i<=N; i++) {
			answer = (answer + K-1) % i + 1;
		}
		
		bw.write(answer+"");
		bw.flush();
		// System.out.println(func(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
	}
	/*
	static int func(int n, int k) {
		if(n==1) {
			return 1;
		}
		return (func(n-1,k)+k-1)%n+1;
	}
	*/
}
