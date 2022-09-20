import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		// Arrays.sort(array)는 시간 초과로 인해 사용할 수 없다. 최악의 경우 시간복잡도가 O(n^2)이기 때문이다.
		// 입력으로는 BufferedReader를 이용하고, 출력으로는 StringBuilder를 이용한다.
		// 자료구조는 ArrayList를 사용하고, 정렬은 Collections.sort(arraylist)를 이용한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arraylist = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			arraylist.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arraylist);
		for(int i=0; i<n; i++) {
			sb.append(arraylist.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
