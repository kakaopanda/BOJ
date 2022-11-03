import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 좌표 정보가 1부터 시작하므로 쿠션을 추가로 넣어준다.
		int array[][] = new int[N+1][N+1];
		
		// 표에 대한 정보를 원본 배열로 기록한다.
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++) {
				array[i][j] = array[i][j] = array[i-1][j]+array[i][j-1]
						-array[i-1][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		
		// 합을 구해야하는 횟수만큼 연산을 수행하고, 결과를 저장한다.
		for(int t=0; t<M; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			sum = array[x2][y2]-array[x1-1][y2]-array[x2][y1-1]+array[x1-1][y1-1];
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
}
