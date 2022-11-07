import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int map[][];
	static int delta[][] = {{1,0},{0,1},{0,-1}};
	static boolean visit[][];
	static boolean percolate = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visit = new boolean[M][N];
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine()," ");
			String input = st.nextToken();
			for(int n=0; n<N; n++) {
				map[m][n] = input.charAt(n)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			dfs(0,i);
		}
		
		if(percolate) {
			sb.append("YES"+"\n");
		}
		else {
			sb.append("NO"+"\n");
		}
		System.out.println(sb);
	}
	
	static boolean dfs(int m, int n) {
		if(m==M-1) {
			percolate = true;
			return true;
		}
		else {
			visit[m][n] = true;
			for(int d=0; d<3; d++) {
				int cm = m + delta[d][0];
				int cn = n + delta[d][1];
				if(cm>=0 && cm<M && cn>=0 && cn<N) {
					if(map[cm][cn]==0 && !visit[cm][cn]) {
						visit[cm][cn] = true;
						dfs(cm,cn);
					}
				}
			}
		}
		return false;
	}
}
