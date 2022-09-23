import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, pipe;
	static char map[][];
	static int delta[][] = {{-1,1},{0,1},{1,1}}; // 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선 순서대로 이동한다.
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine()," ");
			String input = st.nextToken();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
			}
		}
		
		for(int i=0; i<R; i++) {
			// STEP1. 첫 번째 열에서 마지막 열까지 파이프라인이 연결된 경우, 파이프라인의 개수를 증가시킨다.
			if(dfs(i,0)) {
				pipe++;
			}
		}
		sb.append(pipe);
		System.out.println(sb);
	}
	
	static boolean dfs(int r, int c) {
		// STEP2. 파이프라인을 설치할 범위를 벗어나거나, 해당 영역을 이미 방문했거나, 건물인 경우 탐색을 중단한다.
		if(r<0 || r>=R || c<0 || c>=C || map[r][c]=='x' || map[r][c]=='-') {
			return false;
		}
		else {
			// STEP3. 세 방향에 대한 탐색을 수행하여, 해당 행에서 파이프라인의 설치가 가능한지 탐색한다.
			map[r][c] = '-';
			if(c==C-1 || dfs(r-1,c+1) || dfs(r,c+1) || dfs(r+1,c+1)) {
				return true;
			}
		}
		return false;
	}
}
