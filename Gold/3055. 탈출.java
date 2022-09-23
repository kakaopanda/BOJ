import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, time;
	static boolean escape;
	static int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static char map[][];
	static Queue<Pos> queue = new ArrayDeque<>();
	static Queue<Pos> water_queue = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine()," ");
			String str = st.nextToken();
			for(int c=0; c<C; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c]=='S') {
					queue.add(new Pos(r,c));
				}
				else if(map[r][c]=='*') {
					water_queue.add(new Pos(r,c));
				}
			}
		}
		bfs();
		if(escape) {
			System.out.println(time);
		}
		else {
			System.out.println("KAKTUS");
		}
		
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			time++;
			
			int ws = water_queue.size();
			for(int i=0; i<ws; i++) {
				// 고슴도치의 이동보다 물의 확장이 더 먼저 이뤄진다.
				Pos wp = water_queue.poll();
				for(int w=0; w<4; w++) {
					int wx = wp.x+delta[w][0];
					int wy = wp.y+delta[w][1];
					if(wx>=0 && wx<R && wy>=0 && wy<C) {
						if(map[wx][wy]=='.') {
							map[wx][wy] = '*';
							water_queue.add(new Pos(wx,wy));
						}
					}
				}
			}
			
			int ds = queue.size();
			for(int i=0; i<ds; i++) {
				Pos p = queue.poll();
				for(int d=0; d<4; d++) {
					int cx = p.x+delta[d][0];
					int cy = p.y+delta[d][1];
					
					// 상,하,좌,우 4방향에 대해 진출 가능한 방향이 있는 경우
					if(cx>=0 && cx<R && cy>=0 && cy<C) {
						if(map[cx][cy]=='.') {
							map[cx][cy] = 'S';
							queue.add(new Pos(cx,cy));
						}
						else if(map[cx][cy]=='D') {
							escape = true;
							return;
						}
					}
				}
			}
		}
	}
}

class Pos{
	int x, y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}