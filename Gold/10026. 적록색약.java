import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, normal, color;
	static int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static char normal_array[][], color_array[][];
	static boolean normal_check[][], color_check[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
	
		N = Integer.parseInt(st.nextToken());
		normal_array = new char[N][N];
		normal_check = new boolean[N][N];
		color_array = new char[N][N];
		color_check = new boolean[N][N];
		
		// STEP1. 적록색약이 아닌 사람이 봤을 때의 구역 수는 입력 값 그대로 진행한다.
		// STEP2. 적록색약인 사람이 봤을 때의 구역 수는 G를 R로 통일시킨다.
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String str = st.nextToken();
			for(int j=0; j<N; j++) {
				normal_array[i][j] = str.charAt(j);
				if(str.charAt(j)=='G') {
					color_array[i][j] = 'R';
				}
				else {
					color_array[i][j] = str.charAt(j);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!normal_check[i][j]) {
					normal++;
					normal_dfs(i,j);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!color_check[i][j]) {
					color++;
					color_dfs(i,j);
				}
			}
		}
		System.out.println(normal+" "+color);
	}
	
	static void normal_dfs(int x, int y) {
		normal_check[x][y] = true;
		char ch = normal_array[x][y];
		for(int d=0; d<4; d++) {
			int cx = x+delta[d][0];
			int cy = y+delta[d][1];
			if(cx>=0 && cx<N && cy>=0 && cy<N) {
				char next_ch = normal_array[cx][cy];
				if(!normal_check[cx][cy] && ch==next_ch) {
					normal_dfs(cx,cy);
				}
			}
		}
	}
	
	static void color_dfs(int x, int y) {
		color_check[x][y] = true;
		char ch = color_array[x][y];
		for(int d=0; d<4; d++) {
			int cx = x+delta[d][0];
			int cy = y+delta[d][1];
			if(cx>=0 && cx<N && cy>=0 && cy<N) {
				char next_ch = color_array[cx][cy];
				if(!color_check[cx][cy] && ch==next_ch) {
					color_dfs(cx,cy);
				}
			}
		}
	}
}
