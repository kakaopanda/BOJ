import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Math.min(N, M)*2;
		
		// STEP1. 배열의 입력 정보 기록
		// 문제에서 제시한 설명과 동일하게 구현하기 위해 행, 열에 쿠션을 한 칸씩 넣어준다.
		// N과 M중의 최솟값 중, 2로 나눈 나머지가 항상 0임을 숙지하자.
		// 행 혹은 열이 항상 2의 배수임을 활용해야한다.
		// 규칙성 분석 결과, 회전 횟수는 min(N,M)*2에 해당한다.
		// 2*2 = 4, 4*4 = 8, 6*6 = 12..
		// 2*3 = 4, 3*2 = 4, 2*4= 4, 4*2= 4..
		int array[][] = new int[N+1][M+1];
		int rotation[][] = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// STEP2. N*M 배열에 대해, 이동 방향은 총 4가지 종류가 존재한다.
		// (1). 왼쪽(LEFT) : [1][2]...[1][M] 이후 시작 인덱스(+1,+1), 종료 인덱스 (+1,-1)
		// (2). 아래쪽(DOWN) : [1][1]...[N-1][1] 이후 시작인덱스 (+1,+1), 종료 인덱스 (-1,+1)
		// (3). 오른쪽(RIGHT) : [N][1]...[N][M-1] 이후 시작 인덱스 (-1,+1), 종료 인덱스 (-1,-1)
		// (4). 위쪽(UP) : [2][M]...[N][M] 이후 시작 인덱스 (+1,-1), 종료 인덱스 (-1,-1)
		
		int count = 0;
		for(int r=0; r<R; r++) {
			int left_x = 1;
			int left_y = 2;
			int down_x = 1;
			int down_y = 1;
			int right_x = N;
			int right_y = 1;
			int up_x = N;
			int up_y = M;
			
			// 원본 배열을 통해 회전본 배열 생성
			ESCAPE:
			while(true) {
				if(count==C) {
					// 1회 회전된 회전본 배열을 원본에 적용
					for(int i=1; i<=N; i++) {
						for(int j=1; j<=M; j++) {
							array[i][j] = rotation[i][j];
						}
					}
					count = 0;
					break ESCAPE;
				}
				// [LEFT] [1][2] -> [1][1] ... [1][4] -> [1][3]
				for(int i=left_y; i<=M-left_y+2; i++) {
					rotation[left_x][i-1] = array[left_x][i];
				}
				count++;
				left_x++;
				left_y++;
				
				// [DOWN] [1][1] -> [2][1] ... [3][1] -> [4][1]
				for(int i=down_x; i<=N-down_x; i++) {
					rotation[i+1][down_y] = array[i][down_y];
				}
				count++;
				down_x++;
				down_y++;
				
				// [RIGHT] [4][1] -> [4][2] ... [4][3] -> [4][4]
				for(int i=right_y; i<=M-right_y; i++) {
					rotation[right_x][i+1] = array[right_x][i];
				}
				count++;
				right_x--;
				right_y++;
				
				// [UP] [4][4] -> [3][4] ... [2][4] -> [1][4]
				for(int i=up_x; i>=right_y; i--) {
					rotation[i-1][up_y] = array[i][up_y];
				}
				count++;
				up_x--;
				up_y--;
			}
		}
		
		
		// 회전된 배열 출력
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				System.out.print(rotation[i][j]+" ");
			}
			System.out.println();
		}
	}
}
