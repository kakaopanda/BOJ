import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max = Integer.MIN_VALUE;
	static int array[][], copy_array[][];
	static int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean visited[][];
	
	static List<Coordinate> virus_list = new ArrayList<>();
	static List<Coordinate> pill_list = new ArrayList<>();
	
	static int numbers[] = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		copy_array = new int[N][M];
		visited = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int m=0; m<M; m++) {
				array[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		originalToCopy();
		search();
		comb(0,0);
		
		System.out.println(max);
	}
	
	// 배열을 출력하는 함수
	static void print() {
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				System.out.print(array[n][m]+" ");
			}
			System.out.println();
		}
	}
	
	// 바이러스가 존재하는 위치를 탐색하는 함수
	static void search() {
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(array[n][m]==2) {
					virus_list.add(new Coordinate(n,m));
				}
				else if(array[n][m]==0) {
					pill_list.add(new Coordinate(n,m));
				}
			}
		}
	}
	
	// 바이러스를 퍼뜨리는 함수
	static void infection(Coordinate c) {
		Queue<Coordinate> queue = new LinkedList<>();
		visited[c.x][c.y] = true;
		queue.add(c);
		
		while(queue.size()!=0) {
			Coordinate nc = queue.poll();
			for(int d=0; d<4; d++) {
				int nx = nc.x + delta[d][0];
				int ny = nc.y + delta[d][1];
				if(check(nx,ny)) {
					if(!visited[nx][ny]) {
						// 바이러스를 퍼뜨릴 수 있는 경우
						if(array[nx][ny]==0) {
							array[nx][ny] = 2;
							queue.add(new Coordinate(nx,ny));
						}
						else {
							continue;
						}
					}
				}
			}
		}
	}
	
	// 해당 영역이 배열의 내부에 존재하는지 검토하는 함수
	static boolean check(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<M) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static int safe() {
		int count = 0;
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(array[n][m]==0) {
					count++;
				}
			}
		}
		return count;
	}
	
	// 조합을 통해 벽을 3개 세웠을 때, 안전 영역 크기의 최댓값을 구하는 함수
	static void comb(int cnt, int index) {
		// 벽을 모두 세운 경우
		if(cnt==3) {
			for(int i=0; i<3; i++) {
				int px = pill_list.get(numbers[i]).x;
				int py = pill_list.get(numbers[i]).y;
				array[px][py] = 1;
			}
			for(int i=0; i<virus_list.size(); i++) {
				infection(virus_list.get(i));			
			}
			int temp_max = safe();
			if(temp_max > max) {
				max = temp_max;
			}
			copyToOriginal();
			return;
		}
		else {
			for(int i=index; i<pill_list.size(); i++) {
				numbers[cnt] = i;
				comb(cnt+1, i+1);
			}
		}
	}
	
	static void originalToCopy() {
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				copy_array[n][m] = array[n][m];
			}
		}
	}
	
	static void copyToOriginal() {
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				array[n][m] = copy_array[n][m];
			}
		}
	}
}

class Coordinate{
	int x, y;
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}