import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; 	// SCV의 수
	static int SCV[]; 	// SCV N개의 체력
	static int min = Integer.MAX_VALUE; // 모든 SCV를 파괴하기 위한 공격 횟수의 최솟값
	static boolean visited[][][] = new boolean[100][100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		SCV = new int[3];

		st = new StringTokenizer(br.readLine()," ");
		for(int n=0; n<N; n++) {
			SCV[n] = Integer.parseInt(st.nextToken());
		}
		dfs(SCV[0],SCV[1],SCV[2],0);
		System.out.println(min);
	}
	
	static void dfs(int f, int s, int t, int cnt) {
		if(cnt>min) {
			return;
		}
		else {
			// f,s,t에 (9,3,1)을 빼다가 음수가 될 수 있으므로, 음수 인덱스를 방지하기 위해 10을 더해준다.
			if(!visited[f+10][s+10][t+10]) {
				visited[f+10][s+10][t+10] = true;
				
				// CASE1. SCV 3대가 모두 생존한 경우
				if(f>0 && s>0 && t>0) {
					dfs(f-9,s-3,t-1,cnt+1);
					dfs(f-9,s-1,t-3,cnt+1);
					dfs(f-3,s-9,t-1,cnt+1);
					dfs(f-3,s-1,t-9,cnt+1);
					dfs(f-1,s-9,t-3,cnt+1);
					dfs(f-1,s-3,t-9,cnt+1);
				}
				// CASE2. SCV 2대가 생존한 경우
				else if(f>0 && s<=0 && t>0) {
					dfs(f-9,s,t-3,cnt+1);
					dfs(f-3,s,t-9,cnt+1);
				}
				else if(f>0 && s>0 && t<=0) {
					dfs(f-9,s-3,t,cnt+1);
					dfs(f-3,s-9,t,cnt+1);
				}
				else if(f<=0 && s>0 && t>0) {
					dfs(f,s-9,t-3,cnt+1);
					dfs(f,s-3,t-9,cnt+1);
				}
				// CASE3. SCV 1대가 생존한 경우
				else if(f>0 && s<=0 && t<=0) {
					dfs(f-9,s,t,cnt+1);
				}
				else if(f<=0 && s>0 && t<=0) {
					dfs(f,s-9,t,cnt+1);
				}
				else if(f<=0 && s<=0 && t>0) {
					dfs(f,s,t-9,cnt+1);
				}
				// CASE4. SCV가 모두 파괴된 경우
				else {
					if(min>cnt) {
						min = cnt;
					}
					return;
				}
			}
			else {
				return;
			}
		}
	}
}
