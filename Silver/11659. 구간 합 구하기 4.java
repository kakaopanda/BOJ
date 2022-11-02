import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 일반적인 접근 방식처럼, 배열에 저장한뒤 하나씩 더하는 방법으로는 제한 시간을 통과할 수 없다.
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int array[] = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			if(i==0) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			else {
				array[i] = Integer.parseInt(st.nextToken()) + array[i-1];
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int sum = 0;
			if(start==0) {
				sum = array[end];
			}
			else {
				sum = array[end] - array[start-1];
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
}
