import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int M; // 배추 밭의 가로 길이
	static int N; // 배추 밭의 세로 길이
	static int K; // 배추가 심어져 있는 위치의 개수
	static int array[][]; // 배추 밭을 배열로 형상화
	static boolean visit[][]; // 각 위치에 대한 방문 여부를 배열로 활성화
	static int count; /// 필요한 배추흰지렁이의 최소 개수
	static int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}};

	static void dfs(int row, int column) {
		visit[row][column] = true;
		for (int d=0; d<4; d++) {
			int nr = row + delta[d][0];
			int nc = column + delta[d][1];
			if (nr>=0 && nc>=0 && nr<M && nc<N) {
				if (!visit[nr][nc] && array[nr][nc] == 1) {
					dfs(nr, nc);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int result[] = new int[testcase];
		for (int i=0; i<testcase; i++) {
			count = 0;
			M = s.nextInt();
			N = s.nextInt();
			K = s.nextInt();
			array = new int[M][N];
			visit = new boolean[M][N];
			for (int j=0; j<K; j++) {
				int X = s.nextInt();
				int Y = s.nextInt();
				array[X][Y] = 1;
			}

			for (int row=0; row<M; row++) {
				for (int column=0; column<N; column++) {
					if (array[row][column]==1 && !visit[row][column]) {
						dfs(row, column);
						count++;
					}
				}
			}
			result[i] = count;
		}
		for(int i=0; i<testcase; i++) {
			System.out.println(result[i]);
		}
	}
}