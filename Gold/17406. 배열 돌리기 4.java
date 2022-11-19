import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int input[]; // 회전 연산의 정보를 담은 객체들의 인덱스 집합 (숫자 배열) 
	static int numbers[]; // 순열을 통해 구성된 회전 연산 객체들의 인덱스를 담을 배열 (순열 저장 배열)
	static boolean isSelected[];
	
	static int N, M; // 배열 A의 크기 N, M
	static int K; // 회전 연산의 개수 K
	static int C; // 회전 연산 1회시 필요한 작업의 수 C
	static int min = Integer.MAX_VALUE; // 배열의 최솟값 min
	
	static int Rotate_N, Rotate_M; // 회전할 영역의 크기
	static int[][] A; // 원본 배열 A
	static int[][] Backup_A; // 원본 배열을 백업할 배열
	static int[][] Rotate; // 회전 연산의 정보를 담을 배열
	static int[][] Rotate_A; // 원본 배열을 1회 회전한 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 회전 연산에는 인자로 r,c,s가 필요하다.
		Rotate = new int[K][3];
		numbers = new int[K];
		isSelected = new boolean[K];
		
		// 크기가 N*M인 배열 A
		A = new int[N+1][M+1];
		Backup_A = new int[N+1][M+1];
		
		// STEP1. 배열에 대한 정보를 기록한다.
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				Backup_A[i][j] = A[i][j];
			}
		}
		
		// STEP2. 회전 정보를 배열에 기록한다.
		// (r,c,s) -> (3,4,2)
		// 좌상 (r-s,c-s) -> (1,2)
		// 우하 (r+s,c+s) -> (5,6)
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) {
				Rotate[k][j] = Integer.parseInt(st.nextToken());
				// Rotate[i][0] -> r
				// Rotate[i][1] -> c
				// Rotate[i][2] -> s
			}
		}
		
		// STEP3. 순열로 구성된 회전 정보를 통해, 회전 횟수만큼 배열을 회전시킨 뒤 최솟값을 구한다.
		perm(0);
		
		// STEP4. 최솟값을 출력한다.
		sb.append(min);
		System.out.print(sb);
	}
	
	public static void perm(int cnt) {
		// 순열을 통해 회전 횟수만큼의 배열을 구성한 경우
		if(cnt == K) {
			// 회전을 돌리기 전, 원본 배열에 대한 정보 초기화
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					A[i][j] = Backup_A[i][j];
				}
			}
			
			for(int i=0; i<K; i++) {
				rotate_array(numbers[i]);
			}
			
			/*
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					System.out.print(A[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			*/
			calc_array();
			return;
		}
		else {
			for(int i=0; i<K; i++) {
				if(!isSelected[i]) {
					isSelected[i] = true;
					numbers[cnt] = i;
					perm(++cnt);
					isSelected[i] = false;
					cnt--;
				}
			}
		}
	}
	
	public static void rotate_array(int k) {
		int start_x = Rotate[k][0] - Rotate[k][2];
		int start_y = Rotate[k][1] - Rotate[k][2];
		int end_x = Rotate[k][0] + Rotate[k][2];
		int end_y = Rotate[k][1] + Rotate[k][2];
		
		// 회전할 영역의 크기
		Rotate_N = end_x - start_x + 1;
		Rotate_M = end_y - start_y + 1;
		C = (Math.min(Rotate_N, Rotate_M)/2)*4;
		Rotate_A = new int[Rotate_N+1][Rotate_M+1];
		
		int count = 0;
		
		// 좌상 시작위치가 (1,1)이고 우하 끝 위치가 (N,M)일때의 좌표
		int right_x = 1;
		int right_y = 1;
		int down_x = 1;
		int down_y = Rotate_M;
		int left_x = Rotate_N;
		int left_y = Rotate_M;
		int up_x = Rotate_N;
		int up_y = 1;
		
		// 원본 배열을 통해 회전본 배열 생성
		ESCAPE:
		while(true) {
			if(count==C) {
				// 1회 회전된 회전본 배열을 원본에 적용
				for(int i=1; i<=Rotate_N; i++) {
					for(int j=1; j<=Rotate_M; j++) {
						if(Rotate_A[i][j] != 0) {
							A[i+start_x-1][j+start_y-1] = Rotate_A[i][j];
						}
					}
				}

				count = 0;
				break ESCAPE;
			}
			
			// [Right] [1][1] -> [1][2] ... [1][4] -> [1][5]
			for(int i=right_y; i<=Rotate_M-right_y; i++) {
				Rotate_A[right_x][i+1] = A[right_x+start_x-1][i+start_y-1];
			}
			count++;
			right_x++;
			right_y++;
			
			// [DOWN] [1][M] -> [2][M] ... [4][M] -> [5][M]
			for(int i=down_x; i<=Rotate_N-down_x; i++) {
				Rotate_A[i+1][down_y] = A[i+start_x-1][down_y+start_y-1];
			}
			count++;
			down_x++;
			down_y--;
			
			// [LEFT] [N][M] -> [N][M-1] ... [5][3] -> [5][2]
			for(int i=left_y; i>up_y; i--) {
				Rotate_A[left_x][i-1] = A[left_x+start_x-1][i+start_y-1];
			}
			count++;
			left_x--;
			left_y--;
			
			// [UP] [N][1] -> [N-1][1] ... [2][1] -> [1][1]
			for(int i=up_x; i>right_x-1; i--) {
				Rotate_A[i-1][up_y] = A[i+start_x-1][up_y+start_y-1];
			}
			count++;
			up_x--;
			up_y++;
		}
	}
	
	// 배열의 각 행마다의 합을 구한 뒤, 최솟값을 저장한다.
	public static void calc_array() {
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=M; j++) {
				sum += A[i][j];
			}
			if(sum < min) {
				min = sum;
			}
		}
	}
}
