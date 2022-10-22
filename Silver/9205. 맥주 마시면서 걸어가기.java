import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int T, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			List<Coordinate> list = new ArrayList<>();
			boolean[][] visited = new boolean[N+2][N+2];
			
			// STEP1. 집의 좌표
			st = new StringTokenizer(br.readLine()," ");
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			list.add(new Coordinate(hx,hy));
			
			// STEP2. 편의점의 좌표
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine()," ");
				int sx = Integer.parseInt(st.nextToken());
				int sy = Integer.parseInt(st.nextToken());
				list.add(new Coordinate(sx,sy));
			}
			
			// STEP3. 락 페스티벌의 좌표
			st = new StringTokenizer(br.readLine()," ");
			int fx = Integer.parseInt(st.nextToken());
			int fy = Integer.parseInt(st.nextToken());
			list.add(new Coordinate(fx,fy));
			
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					// 서로 도달하는데 필요한 거리가 1000이하인 경우, 방문가능하다고 표시한다.
					if(distance(list.get(i).x, list.get(i).y, list.get(j).x, list.get(j).y)) {
						visited[i][j] = true;
					}
				}
			}
			
			for(int k=0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<N+2; j++) {
						// 출발점(0)에서 편의점(1)을 거쳐 도착점(2)에 도달할 수 있으면, 출발점에서 도착점에 도달할 수 있다.
						// [0][1] && [1][2] -> [0][2]
						if(visited[i][k] && visited[k][j]) {
							visited[i][j] = true;
						}
					}
				}
			}
			
			if(visited[0][N+1]) {
				sb.append("happy"+"\n");
			}
			else {
				sb.append("sad"+"\n");
			}
		}
		System.out.println(sb);
	}
	
	static boolean distance(int x1, int y1, int x2, int y2) {
		int d = Math.abs(x1-x2)+Math.abs(y1-y2); 
		if(d<=1000) {
			return true;
		}
		else {
			return false;
		}
	}
}

class Coordinate{
	int x,y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
}
