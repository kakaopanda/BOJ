import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	// static int matrix[][]; -> 인접행렬로 수행시 시간 초과가 발생할 수 있다.
	static ArrayList<Integer> array[];
	static boolean visit[];
	static int N, M, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 사람의 수만큼 ArrayList를 생성한다.
		array = new ArrayList[N];
		for(int i=0; i<N; i++) {
			array[i] = new ArrayList<>();
		}
		visit = new boolean[N];
		
		// 친구 관계에 해당하는 양쪽 인덱스에 쌍방향으로 서로의 인덱스를 추가한다.
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			array[from].add(to);
			array[to].add(from);
		}
		
		// 각 인덱스에 대한 방문 여부를 기록하고, 첫 번째 사람부터 마지막 사람까지 관계 탐색을 수행한다.
		for(int i=0; i<N; i++) {
			if(answer==1) {
				break;
			}
			visit[i] = true;
			dfs(i,0);
			visit[i] = false;
		}
		System.out.println(answer);
	}
	
	static void dfs(int cur, int depth) {
		if(depth==4) {
			answer = 1;
			return;
		}
		else {
			// 현재 탐색 인덱스(cur)와 관계가 있는 인덱스들에 대한 탐색을 수행한다.
			for(int i=0; i<array[cur].size(); i++) {
				if(!visit[array[cur].get(i)]) {
					visit[array[cur].get(i)] = true;
					dfs(array[cur].get(i), depth+1);
					visit[array[cur].get(i)] = false;
				}
				else {
					continue;
				}
			}
		}
	}
}
