import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		List<Long> arrayList = new ArrayList<>();
		
		// 점화식의 규칙성을 위해 추가로 넣어준 요소
		arrayList.add((long)0);
		arrayList.add((long)0);
		arrayList.add((long)0);
		arrayList.add((long)0);
		
		// 첫 인덱스
		arrayList.add((long)1); 
		arrayList.add((long)1);
		arrayList.add((long)1);
		arrayList.add((long)2);
		arrayList.add((long)2);
		
		// N의 범위는 [1,100]이므로, 100번째 요소까지만 만든다.
		for(int i=8; i<=102; i++) {
			long calc = arrayList.get(i)+arrayList.get(i-4);
			arrayList.add(calc);
		}
		for(int i=0; i<T; i++) {
			int N = s.nextInt();
			System.out.println(arrayList.get(N+4-1));
		}
	}
}
