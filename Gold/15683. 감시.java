import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

 하나의 CCTV에 대해, 4가지 방향에 대한 탐색이 모두 수행되어야한다.
 방향에 대한 결정은 중복순열로 이뤄져야한다. CCTV가 4대인 경우 (0,0,0,0) ~ (3,3,3,3)
 4대의 CCTV의 경우, 전체 경우의 수는 4444 = 256가지가 된다.
 N대의 CCTV의 경우, 전체 경우의 수는 (4^N)가지가 된다.
 CCTV가 최대 8개까지 주어질 수 있으므로, 가능한 전체 경우의 수는 4^8 = 2^16 = 1024  64 가지이다.
public class Main {
	static int direction[] = {0,1,2,3};
	static int selected[];
	static int count = 0;
	static int N, M;
	static int original_office[][], copy_office[][];
	static ListCCTV cctvList  = new ArrayList();
	static int blind_spot = 0;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), );
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		original_office = new int[N][M];
		copy_office = new int[N][M];
		
		 STEP1. 사무실의 정보를 입력 받고, CCTV의 좌표를 ArrayList에 추가한다.
		for(int i=0; iN; i++) {
			st = new StringTokenizer(br.readLine(), );
			for(int j=0; jM; j++) {
				original_office[i][j] = Integer.parseInt(st.nextToken());
				copy_office[i][j] = original_office[i][j];
				if(original_office[i][j]==1  original_office[i][j]==2 
						original_office[i][j]==3  original_office[i][j]==4 
						original_office[i][j]==5) {
					cctvList.add(new CCTV(original_office[i][j],i,j));
				}
			}
		}
		count = cctvList.size();
		operation(0);
		sb.append(min);
		System.out.println(sb);
	}
	
	 사무실의 사각지대의 개수를 세는 함수
	static void count_zero() {
		for(int i=0; iN; i++) {
			for(int j=0; jM; j++) {
				if(copy_office[i][j]==0) {
					blind_spot++;
				}
			}
		}
	}
	
	static void rotation(CCTV tv, int direct) {
		 System.out.println(tv.cctv+,+direct);
		 CCTV는 1번부터 5번까지 있다.
		switch(tv.cctv) {	
			case 1
				 CCTV 1이 회전하는 경우에 대한 감시 영역
				 0  왼쪽, 1  오른쪽, 2  위쪽, 3  아래쪽
				switch(direct) {
					case 0
						for(int i=tv.y-1; i=0; i--) {
							if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}  CCTV가 감시 가능한 영역을 -1로 표현한다.
							else if(copy_office[tv.x][i]==6) {break;}  CCTV의 감시 영역에 벽이 있는 경우, 반복을 중단한다.
							else {continue;}  CCTV의 감시 영역에 또다른 CCTV가 있는 경우, 다음 칸으로 건너뛴다.
						}
						break;
					case 1
						for(int i=tv.y+1; iM; i++) {
							if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}
							else if(copy_office[tv.x][i]==6) {break;}
							else {continue;} 
						}
						break;
					case 2
						for(int j=tv.x-1; j=0; j--) {
							if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
							else if(copy_office[j][tv.y]==6) {break;}
							else {continue;} 
						}
						break;
					case 3
						for(int j=tv.x+1; jN; j++) {
							if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
							else if(copy_office[j][tv.y]==6) {break;}
							else {continue;}
						}
						break;
				}
				break;
			case 2
				 CCTV 2가 회전하는 경우에 대한 감시 영역
				 0,1  좌우 양쪽, 2,3  상하 양쪽
				switch(direct) {
				case 0
				case 1
					for(int i=tv.y-1; i=0; i--) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}  CCTV가 감시 가능한 영역을 -1로 표현한다.
						else if(copy_office[tv.x][i]==6) {break;}  CCTV의 감시 영역에 벽이 있는 경우, 반복을 중단한다.
						else {continue;}  CCTV의 감시 영역에 또다른 CCTV가 있는 경우, 다음 칸으로 건너뛴다.
					}
					for(int i=tv.y+1; iM; i++) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}
						else if(copy_office[tv.x][i]==6) {break;}
						else {continue;} 
					}
					break;
				case 2
				case 3
					for(int j=tv.x+1; jN; j++) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;}
					}
					for(int j=tv.x-1; j=0; j--) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;} 
					}
					break;
				}
				break;
			case 3
				 CCTV 3이 회전하는 경우에 대한 감시 영역
				 0  우상, 1  우하, 2  좌하, 3  좌상
				switch(direct) {
				case 0
					for(int i=tv.y+1; iM; i++) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}
						else if(copy_office[tv.x][i]==6) {break;}
						else {continue;} 
					}
					for(int j=tv.x-1; j=0; j--) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;} 
					}
					break;
				case 1
					for(int i=tv.y+1; iM; i++) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}
						else if(copy_office[tv.x][i]==6) {break;}
						else {continue;} 
					}
					for(int j=tv.x+1; jN; j++) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;}
					}
					break;
				case 2
					for(int i=tv.y-1; i=0; i--) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}  CCTV가 감시 가능한 영역을 -1로 표현한다.
						else if(copy_office[tv.x][i]==6) {break;}  CCTV의 감시 영역에 벽이 있는 경우, 반복을 중단한다.
						else {continue;}  CCTV의 감시 영역에 또다른 CCTV가 있는 경우, 다음 칸으로 건너뛴다.
					}
					for(int j=tv.x+1; jN; j++) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;}
					}
					break;
				case 3
					for(int i=tv.y-1; i=0; i--) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}  CCTV가 감시 가능한 영역을 -1로 표현한다.
						else if(copy_office[tv.x][i]==6) {break;}  CCTV의 감시 영역에 벽이 있는 경우, 반복을 중단한다.
						else {continue;}  CCTV의 감시 영역에 또다른 CCTV가 있는 경우, 다음 칸으로 건너뛴다.
					}
					for(int j=tv.x-1; j=0; j--) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;} 
					}
					break;
				}
				break;
			case 4
				 CCTV 4가 회전하는 경우에 대한 감시 영역
				 0  좌상우, 1  상우하, 2  좌우하, 3  좌상하
				switch(direct) {
				case 0
					for(int i=tv.y-1; i=0; i--) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}  CCTV가 감시 가능한 영역을 -1로 표현한다.
						else if(copy_office[tv.x][i]==6) {break;}  CCTV의 감시 영역에 벽이 있는 경우, 반복을 중단한다.
						else {continue;}  CCTV의 감시 영역에 또다른 CCTV가 있는 경우, 다음 칸으로 건너뛴다.
					}
					for(int i=tv.y+1; iM; i++) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}
						else if(copy_office[tv.x][i]==6) {break;}
						else {continue;} 
					}
					for(int j=tv.x-1; j=0; j--) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;} 
					}
					break;
				case 1
					for(int i=tv.y+1; iM; i++) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}
						else if(copy_office[tv.x][i]==6) {break;}
						else {continue;} 
					}
					for(int j=tv.x-1; j=0; j--) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;} 
					}
					for(int j=tv.x+1; jN; j++) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;}
					}
					break;
				case 2
					for(int i=tv.y-1; i=0; i--) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}  CCTV가 감시 가능한 영역을 -1로 표현한다.
						else if(copy_office[tv.x][i]==6) {break;}  CCTV의 감시 영역에 벽이 있는 경우, 반복을 중단한다.
						else {continue;}  CCTV의 감시 영역에 또다른 CCTV가 있는 경우, 다음 칸으로 건너뛴다.
					}
					for(int i=tv.y+1; iM; i++) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}
						else if(copy_office[tv.x][i]==6) {break;}
						else {continue;} 
					}
					for(int j=tv.x+1; jN; j++) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;}
					}
					break;
				case 3
					for(int i=tv.y-1; i=0; i--) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}  CCTV가 감시 가능한 영역을 -1로 표현한다.
						else if(copy_office[tv.x][i]==6) {break;}  CCTV의 감시 영역에 벽이 있는 경우, 반복을 중단한다.
						else {continue;}  CCTV의 감시 영역에 또다른 CCTV가 있는 경우, 다음 칸으로 건너뛴다.
					}
					for(int j=tv.x-1; j=0; j--) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;} 
					}
					for(int j=tv.x+1; jN; j++) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;}
					}
					break;
				}
				break;
			case 5
				 CCTV 5가 회전하는 경우에 대한 감시 영역
				 0,1,2,3  상,하,좌,우 4방향
				switch(direct) {
				case 0
				case 1
				case 2
				case 3
					for(int i=tv.y-1; i=0; i--) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}  CCTV가 감시 가능한 영역을 -1로 표현한다.
						else if(copy_office[tv.x][i]==6) {break;}  CCTV의 감시 영역에 벽이 있는 경우, 반복을 중단한다.
						else {continue;}  CCTV의 감시 영역에 또다른 CCTV가 있는 경우, 다음 칸으로 건너뛴다.
					}
					for(int i=tv.y+1; iM; i++) {
						if(copy_office[tv.x][i]==0) {copy_office[tv.x][i] = -1;}
						else if(copy_office[tv.x][i]==6) {break;}
						else {continue;} 
					}
					for(int j=tv.x-1; j=0; j--) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;} 
					}
					for(int j=tv.x+1; jN; j++) {
						if(copy_office[j][tv.y]==0) {copy_office[j][tv.y] = -1;}
						else if(copy_office[j][tv.y]==6) {break;}
						else {continue;}
					}
				}
				break;
			}
	}
	
	 변환된 사본 배열을 원본 배열의 값으로 되돌리는 함수
	static void copytooriginal() {
		for(int i=0; iN; i++) {
			for(int j=0; jM; j++) {
				copy_office[i][j] = original_office[i][j];
			}
		}
	}
	
	static void print_operation() {
		for(int i=0; iN; i++) {
			for(int j=0; jM; j++) {
				System.out.print(copy_office[i][j]+ );
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void operation(int depth) {
		if(depth==0) {
			selected = new int[count];
			for(int i=0; iN; i++) {
				for(int j=0; jM; j++) {
					copy_office[i][j] = original_office[i][j];
				}
			}
		}
		
		 존재하는 CCTV를 모두 어떤 방향으로 돌릴지 결정한 경우
		if(depth==count) {
			blind_spot = 0;
			 주어진 회전 방향대로 각 CCTV를 회전시킨다.
			for(int i=0; icount; i++) {
				rotation(cctvList.get(i), selected[i]);
			}
			count_zero();
			if(blind_spot  min) {
				min = blind_spot;
			}
			return;
		}
		else {
			for(int i=0; i4; i++) {
				copytooriginal();
				selected[depth] = i;
				operation(depth+1);
			}
		}
	}
}

class CCTV{
	int cctv;
	int x;
	int y;
	public CCTV(int cctv, int x, int y) {
		this.cctv = cctv;
		this.x = x;
		this.y = y;
	}
}