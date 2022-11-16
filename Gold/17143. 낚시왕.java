import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C, M;
	static int total_size, king;
	static int array[][];
	static List<Shark> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			list.add(new Shark(r,c,s,d,z));
		}
		
		// 낚시왕이 먼저 이동하여 상어를 잡은 뒤에 상어의 이동이 시작된다.
		for(int c=0; c<C; c++) {
			// 1. 낚시왕 이동(배열 중 열의 크기만큼 이동한다.)
			king++;
			
			// 2. 상어 사냥 및 크기 합산
			hunt(king);
			
			// 3. 상어 이동 및 격자판 배치
			for(int i=0; i<list.size(); i++) {
				move(list.get(i));
			}
			
			// 4. 동일한 위치에 존재하는 상어들 중, 최강 상어만 1마리 생존
			// R행 C열의 배열을 생성한다. 

			survive();
		}
		System.out.println(total_size);
	}
	
	static void arrangement() {
		array = new int[R+1][C+1];
		for(int i=0; i<list.size(); i++) {
			Shark s = list.get(i);
			array[s.r][s.c]++;
		}
	}
	
	static void survive() {
		// 전체 배열에 상어들을 배치하여, 상어가 2마리 이상 존재하는 곳을 탐색한다.
		arrangement();
		for(int r=1; r<=R; r++) {
			for(int c=1; c<=C; c++) {
				// 상어가 2마리 이상 존재할 경우
				if(array[r][c]>1) {
					List<Shark> max_shark = new ArrayList<>();
					for(int i=list.size()-1; i>=0; i--) {
						Shark s = list.get(i);
						if(r==s.r && c==s.c) {
							max_shark.add(list.get(i));
							list.remove(i);
						}
					}
					Collections.sort(max_shark, new Comparator<Shark>() {
						// 상어를 크기 순으로 내림차순 정렬한다.
						@Override
						public int compare(Shark o1, Shark o2) {
							// TODO Auto-generated method stub
							return o2.z-o1.z;
						}
					});
					list.add(max_shark.get(0));
				}
			}
		}
	}
	
	static void hunt(int king) {
		// 상어들이 존재하는 위치를 행을 기준으로 오름차순 정렬한다.
		Collections.sort(list);
		survive();

		// 열은 낚시왕의 위치로 이미 고정되었으므로, 행에 대해서만 반복한다.
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).c==king) {
				total_size += list.get(i).z;
				list.remove(i);
				break;
			}
		}
	}
	
	static void print() {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(array[r][c]);
			}
			System.out.println();
		}
	}
	
	// 상어의 위치 및 방향을 변경시키는 함수
	static void move(Shark shark) {
		// 상어는 입력으로 주어진 속도로 이동하고, 상어가 이동하려는 칸이 격자판의 경계를 넘는 경우에는 방향을 반대로 바꿔서 속력을 유지한 채 이동한다.
		// 상어의 이동방향이 1,2인 경우 x좌표만 변동하며, 이동방향이 3,4인 경우 y좌표만 변동한다.
		// 상어가 이동하는 경우는 다음의 세가지이다.
		// (1). 이동하려는 좌표가 배열의 왼쪽 및 오른쪽 범위를 넘지 않는 경우
		// (2). 이동하려는 좌표가 배열의 왼쪽 혹은 위쪽 범위(-)를 넘는 경우
		// (3). 이동하려는 좌표가 배열의 오른쪽 혹은 아래쪽 범위(+)를 넘는 경우

		int distance = shark.s;
		while(distance>0) {
			switch(shark.d) {
				case 1:
					if(check(shark.r-1, shark.c)) {
						distance--;
						shark.r -= 1;
					}
					else {
						distance--;
						shark.d = 2;
						shark.r = 2;
					}
					break;
				case 2:
					if(check(shark.r+1, shark.c)) {
						distance--;
						shark.r += 1;
					}
					else {
						distance--;
						shark.d = 1;
						shark.r = R-1;
					}
					break;
				case 3:
					if(check(shark.r, shark.c+1)) {
						distance--;
						shark.c += 1;
					}
					else {
						distance--;
						shark.d = 4;
						shark.c = C-1;
					}
					break;
				case 4:
					if(check(shark.r, shark.c-1)) {
						distance--;
						shark.c -= 1;
					}
					else {
						distance--;
						shark.d = 3;
						shark.c = 2;
					}
					break;
			}
		}
	}
	
	// 상어가 이동할 위치가 배열을 벗어났는지 검사하는 함수
	static boolean check(int x, int y) {
		if(x>0 && x<=R && y>0 && y<=C) {
			return true;
		}
		else {
			return false;
		}
	}
}

class Shark implements Comparable<Shark>{
	int r,c; // 상어의 위치
	int s; // 상어의 속력
	int d; // 상어의 이동방향(위쪽 1, 아래쪽 2, 오른쪽 3, 왼쪽 4)
	int z; // 상어의 크기
	
	public Shark(int r, int c, int s, int d, int z) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
	}

	@Override
	public int compareTo(Shark o) {
		// TODO Auto-generated method stub
		return this.r-o.r;
	}
}