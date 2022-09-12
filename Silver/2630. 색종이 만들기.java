import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int blue_count = 0;
	static int white_count = 0;
	static int array[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		array = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		white_cut(0,0,N);
		blue_cut(0,0,N);
		sb.append(white_count+"\n");
		sb.append(blue_count);
		System.out.println(sb);
	}
	
	static void blue_cut(int x, int y, int size) {		
		// STEP1. 해당 영역을 자를 수 있는 경우
		if(blue_possible(x,y,size)) {
			blue_count++;
			return;
		}
		// STEP2. 해당 영역을 자를 수 없는 경우
		else {
			if(size==1) {
				return;
			}
			size /= 2;
			blue_cut(x,y,size);
			blue_cut(x+size,y,size);
			blue_cut(x,y+size,size);
			blue_cut(x+size,y+size,size);
		}
	}
	
	static boolean blue_possible(int x, int y, int size) {
		boolean check = true;
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(array[i][j]!=1) {
					check = false;
				}
			}
		}
		return check;
	}
	
	static void white_cut(int x, int y, int size) {
		// STEP1. 해당 영역을 자를 수 있는 경우
		if(white_possible(x,y,size)) {
			white_count++;
			return;
		}
		// STEP2. 해당 영역을 자를 수 없는 경우
		else {
			if(size==1) {
				return;
			}
			size /= 2;
			white_cut(x,y,size);
			white_cut(x+size,y,size);
			white_cut(x,y+size,size);
			white_cut(x+size,y+size,size);
		}
	}
	
	static boolean white_possible(int x, int y, int size) {
		boolean check = true;
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(array[i][j]!=0) {
					check = false;
				}
			}
		}
		return check;
	}
}
