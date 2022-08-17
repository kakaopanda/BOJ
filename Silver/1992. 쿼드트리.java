import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int array[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		array = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String str = st.nextToken();
			char input[] = str.toCharArray();
			for(int j=0; j<N; j++) {
				array[i][j] = input[j]-'0';
			}
		}
		
		QuadTree(0,0,N);
		System.out.println(sb);
	}
	
	// 압축 가능 여부를 통해, 이미지를 압축하고 쿼드트리를 구성하는 함수
	static void QuadTree(int x, int y, int size) {
		// 첫 번째로 진입할 때 모든 영역에 대해 압축이 가능하면 괄호를 안써줘도 된다.
		if(compression(x,y,size)) {
			sb.append(array[x][y]);
		}
		// 세부 영역으로 압축을 수행하는 경우, 시작은 괄호를 열고 끝은 괄호를 닫아줘야한다.
		else {
			sb.append("(");
			size /= 2;
			// Case1. 왼쪽 위 첫 번째 영역에 대한 압축수행
			QuadTree(x, y, size);
			
			// Case2. 오른쪽 위 두 번째 영역에 대한 압축 수행
			QuadTree(x, y+size, size);
			
			// Case3. 왼쪽 아래 세 번째 영역에 대한 압축 수행
			QuadTree(x+size, y, size);
			
			// Case4. 오른쪽 아래 네 번째 영역에 대한 압축 수행
			QuadTree(x+size, y+size, size);
			
			sb.append(")");
		}
	}
	
	// 처음 좌표에서 검사 영역까지 압축 가능 여부를 검사하는 함수
	static boolean compression(int x, int y, int size) {
		boolean check = true;
		
		// STEP1. 처음 좌표를 검사 기준으로 설정한다.
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(array[x][y]!=array[i][j]) {
					check = false;
				}
			}
		}
		return check;
	}
}
