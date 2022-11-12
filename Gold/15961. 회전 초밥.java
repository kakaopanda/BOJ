import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, D, K, C;
	static int max = Integer.MIN_VALUE;
	static int array[];
	static int visited[]; // 동일한 종류의 초밥이 여러개 있을 수 있으므로, 정수형 배열로 선언한다.
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 초밥의 배치는 1차원 행렬로 표현하며, 처음과 끝이 서로 인접해있다고 가정한다.
		array = new int[N];
		visited = new int[D+1]; // 초밥의 종류는 1이상 D이하로 표현된다.
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			array[n] = Integer.parseInt(st.nextToken());
		}
		
		// 초밥 벨트에 놓인 접시의 수가 300만개가 될 수 있으므로, 시간 초과를 방지하기 위해 슬라이딩 윈도우를 이용한다.
		// STEP1. 윈도우를 돌리기 전, 최초 초기화를 수행한다.
		sum = 0;
		for(int i=0; i<K; i++) {
			if(visited[array[i]]==0) {
				sum++;
			}
			visited[array[i]]++;
		}
		
		if(max < sum) {
			max = sum;
		}
		
		// STEP2. 맨 앞 요소를 하나 빼고, 맨 뒤 요소를 하나 넣으면서 검사한다.
		for(int i=1; i<N; i++) {
			visited[array[i-1]]--;
			if(visited[array[i-1]]==0) {
				sum--;
			}
			
			if(visited[array[(i+K-1)%N]]==0) {
				sum++;
			}
			visited[array[(i+K-1)%N]]++;
			
			
			// STEP3. 쿠폰으로 받은 초밥을 초밥 가짓수에 반영한다.
			if(sum>=max) {
				if(visited[C]==0) {
					max = sum+1;
				}
				else {
					if(max < sum) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}
