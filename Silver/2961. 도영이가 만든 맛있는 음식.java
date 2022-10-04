import java.util.Scanner;

public class Main {
	static int N;
	static int answer = Integer.MAX_VALUE;
	static int array[][];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		array = new int[N][2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				array[i][j] = s.nextInt();
 			}
		}
		partial_sum(0, 1, 0);
		System.out.println(answer);
	}
	static void partial_sum(int cnt, int sour, int bitter) {
		if(cnt==N) {
			// 요리를 완성하기 위해서 적어도 재료를 한 개이상 사용해야한다.
			if(sour!=0 && bitter!=0) {
				answer = Math.min(answer, Math.abs(sour-bitter));
			}
			return;
		}
		// Case1. 해당 인덱스의 재료를 선택한 경우
		partial_sum(cnt+1, sour*array[cnt][0], bitter+array[cnt][1]);
		
		// Case2. 해당 인덱스의 재료를 선택하지 않은 경우
		partial_sum(cnt+1, sour, bitter);
	}
}
