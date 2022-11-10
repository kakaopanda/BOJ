import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int chicken_distance[];
	static int numbers[];
	static int N, M, cnt, answer = Integer.MAX_VALUE;
	static ArrayList<Coordinate> home;
	static ArrayList<Coordinate> chicken;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 도시의 크기 N
		M = Integer.parseInt(st.nextToken()); // 치킨 집의 개수 M
		
		// STEP1. 도시의 정보를 배열에 기록한다.
		// 문제에서 제시한 설명과 배열의 인덱스를 일치시키기 위해 쿠션을 넣어준다.
		map = new int[N+1][N+1];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// STEP2. 도시의 정보에서 집과 치킨집의 좌표 정보를 추출한다.
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j]==1) {
					home.add(new Coordinate(i,j));
				}
				else if(map[i][j]==2) {
					chicken.add(new Coordinate(i,j));
				}
				else {
					continue;
				}
			}
		}
		
		// STEP3. 각 집에 대한 치킨 거리를 구한 뒤, 도시의 치킨 거리를 구한다.
		// 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다.
		// 도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.
		// 임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|이다.
		chicken_distance = new int[home.size()];
		for(int i=0; i<home.size(); i++) {
			chicken_distance[i] = Integer.MAX_VALUE;
		}
		
		// STEP4. 치킨 집의 수에 따른 도시의 치킨 거리를 구한다.
		// 폐업시키지 않을 치킨집은 조합을 통해 골라낸다.
		numbers = new int[M];
		combination(0,0);
		System.out.println(answer);
		// System.out.println("count : "+count);
	}
	// 두 점(집과 치킨집) 사이의 거리를 구할 함수 distance
	static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	
	static void combination(int cnt, int index) {
		if(cnt==M) {
			// 각 집에 대한 치킨 거리를 구한다.
			// 각 집에 대한 치킨 거리를 구하기 전, 치킨 거리에 대한 정보를 초기화한다.
			chicken_distance = new int[home.size()];
			for(int i=0; i<home.size(); i++) {
				chicken_distance[i] = Integer.MAX_VALUE;
			}
			for(int i=0; i<home.size(); i++) {
				for(int j=0; j<M; j++) {
					if(chicken_distance[i] >
					 distance(home.get(i).x, home.get(i).y, chicken.get(numbers[j]).x, chicken.get(numbers[j]).y)) {
						chicken_distance[i] = distance(home.get(i).x, home.get(i).y, chicken.get(numbers[j]).x, chicken.get(numbers[j]).y);
					}
				}
			}
			int temp_answer = 0;
			for(int i=0; i<home.size(); i++) {
				temp_answer += chicken_distance[i];
			}
			answer = Math.min(answer, temp_answer);
			return;
		}
		else {
			for(int i=index; i<chicken.size(); i++) {
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