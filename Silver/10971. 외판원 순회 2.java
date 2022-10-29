import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static boolean visit[];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			visit[i] = true;
			dfs(i,i,0,0);
			visit[i] = false;
		}
		
		sb.append(min+"\n");
		System.out.println(sb);
	}
	
	static void dfs(int start, int cur, int cost, int cnt) {
		if(cnt==N-1) {
			if(map[cur][start]!=0) {
				cost += map[cur][start];
				if(min > cost) {
					min = cost;
				} 
			}
            return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i] && map[cur][i] != 0) {
				visit[i] = true;
				dfs(start, i, cost+map[cur][i], cnt+1);
				visit[i] = false;
			}
		}
	}
}
