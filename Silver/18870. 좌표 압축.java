import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int array[] = new int[N];
		int sorted_array[] = new int[N];
		
		// 좌표 정보를 배열에 기록한다.
		// 2 4 -10 4 -9
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			sorted_array[i] = array[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최솟값부터 최댓값까지 우선순위를 부여하기 위해, 좌표 정보를 오름차순 정렬한다.
		// -10 -9 4 4 2
		Arrays.sort(sorted_array);
		
		// (Key, Value) -> (Value, Priority)
		HashMap<Integer,Integer> map = new HashMap<>();
		int priority = 0;
		map.put(sorted_array[0], priority++);
		for(int i=1; i<N; i++) {
			// 이미 중복된 자료가 존재하여, 우선순위를 추가할 필요가 없는 경우
			if(map.containsKey(sorted_array[i])) {
				continue;
			}
			// 우선순위를 새롭게 추가해야하는 경우
			else {
				map.put(sorted_array[i], priority++);
			}
		}

		for(int i=0; i<N; i++) {
			sb.append(map.get(array[i])+" ");
		}
		
		System.out.println(sb);
	}
}
