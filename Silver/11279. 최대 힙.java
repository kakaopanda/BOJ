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
				return Math.abs(o2)-Math.abs(o1);
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
