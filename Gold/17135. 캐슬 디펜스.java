import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int map[][], copy_map[][];
	static int numbers[];
	static boolean select[];
	static int N, M, D;
	static int counting = 0;
	static int max = Integer.MIN_VALUE;
	static int one_round_max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M]; // 성을 포함하여 하나의 행을 추가해서 만든다.
		copy_map = new int[N+1][M];
		numbers = new int[3]; // 궁수들의 위치를 기록할 배열 (0 ~ M-1)
		select = new boolean[M];
		
		// STEP1. 적의 위치를 배열에 기록한다.
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy_map[i][j] = map[i][j];
			}
		}
		
		// STEP2. 조합을 통해 궁수의 위치 구성을 완성한다.
		combination(0,0);	
		System.out.println(max);
	}
	
	static void copytooriginal() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = copy_map[i][j];
			}
		}
	}
	
	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	
	// 한 라운드가 끝날 때 마다 적은 한 칸씩 내려온다.
	static void round() {
		for(int i=N-2; i>=0; i--) {
			for(int j=0; j<M; j++) {
				map[i+1][j] = map[i][j];
			}
		}
		// 맨 첫 번째 줄은 적이 없으므로 0이 내려오도록 한다.
		for(int j=0; j<M; j++) {
			map[0][j] = 0;
		}
	}
	
	// 적의 존재 유무를 확인하여 게임의 종료 여부를 확인한다.
	static boolean gameover() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	static int attack() {
		// STEP1. 현재 궁수들의 모든 좌표를 획득한다.
		List<Coordinate> archerList = new ArrayList<>();
		for(int i=0; i<M; i++) {
			if(map[N][i]==2) {
				archerList.add(new Coordinate(N,i));
			}
		}
		
		// STEP2. 현재 몬스터들의 모든 좌표를 획득한다.
		List<Coordinate> monsterList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					monsterList.add(new Coordinate(i,j));
				}
			}
		}
		
		List<Coordinate> killList = new ArrayList<>();
		int one_round_kill = 0;
		for(int i=0; i<archerList.size(); i++) {
			// 각 궁수 좌표에 대해, 처치가 이뤄질 몬스터의 좌표를 계산한다.(서로 다른 궁수가 동일한 몬스터 공격가능)
			Coordinate c = archerList.get(i);
			int min = Integer.MAX_VALUE;
			
			Coordinate k = new Coordinate(0,0);
			
			// 가장 왼쪽에 위치한 적이 표적으로 선정되려면, 가장 먼저 비교되어야한다. (x값에 대한 오름차순 정렬)
			Collections.sort(monsterList, new Comparator<Coordinate>() {
				@Override
				public int compare(Coordinate o1, Coordinate o2) {
					if(o1.x==o2.x) {
						return o2.x-o1.x;
					}
					return o1.y-o2.y;
				}
			});
			
			/*
			for(int j=0; j<monsterList.size(); j++) {
				System.out.print(monsterList.get(j).x+","+monsterList.get(j).y+" ");
			}
			System.out.println();
			*/
			
			for(int j=0; j<monsterList.size(); j++) {
				Coordinate m = monsterList.get(j);
				int d = getDistance(c.x, c.y, m.x, m.y);
				
				// 궁수로부터 떨어진 각 몬스터들의 거리를 계산한 뒤, 해당 객체를 저장해두고 최솟값인게 확정되면 공격 가능 여부를 확인한다.
				if(min > d) {
					min = d;
					k = m;
				}
			}
			
			// 최솟값이 공격 가능 범위에 해당되면, 해당 몬스터를 처치한다.
			if(min <= D) {
				// 아직 해당 위치의 몬스터가 처치되지 않은 경우
				if(map[k.x][k.y]==1) {
					map[k.x][k.y]=0;
					one_round_kill++;
				}
			}
			if(one_round_max<one_round_kill) {
				one_round_max = one_round_kill;
			}
		}
		return one_round_max;
	}
	
	static void combination(int cnt, int index) {
		// 궁수들의 위치 조합을 완성한 경우
		if(cnt==3) {
			copytooriginal();
			// 궁수들의 위치 조합을 배열에 기록하기 전, 해당 영역만 초기화해준다.
			for(int i=0; i<M; i++) {
				map[N][i] = 0;
			}
			
			// 궁수들의 위치 조합을 배열에 기록한다.
			for(int i=0; i<3; i++) {
				map[N][numbers[i]] = 2;
			}
			
			int kill = 0;
			// 몬스터가 전부 없어질 때까지 라운드는 계속된다.
			while(true) {
				one_round_max = 0;
				
				// 몬스터가 모두 제거 되었다면 게임을 종료하고, 그렇지 않다면 라운드를 진행한다.
				if(gameover()) {
					if(max<kill) {
						max = kill;
					}
					return;
				}
				else {
					// 테스트케이스 6번은 가장 왼쪽에 있는 적을 공격하도록 해야 통과할 수 있다.
					kill += attack();
					round();
					continue;
				}
			}
		}
		else {
			for(int i=index; i<M; i++) {
				numbers[cnt] = i;
				combination(cnt+1, i+1);
			}
		}
	}
}

class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
