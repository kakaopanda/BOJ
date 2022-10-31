import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 연산의 개수 N
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 절대값이 동일한 경우, 더 작은 값(음수)에 우선순위를 부여한다. (오름차순)
				if(Math.abs(o1)==Math.abs(o2)) {
					return o1-o2;
				}
				// 절대값이 작은 자료에 우선순위를 부여한다. (오름차순)
				return Math.abs(o1)-Math.abs(o2);
			}
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int input = Integer.parseInt(st.nextToken());
			
			if(input==0) {
				// 우선순위큐가 비어있지 않은 경우, 절댓값이 가장 작은 값을 출력한다.
				if(!pq.isEmpty()) {
					System.out.println(pq.poll());
				}
				else {
					System.out.println(0);
				}
			}
			else {
				pq.add(input);
			}
		}
	}
}
