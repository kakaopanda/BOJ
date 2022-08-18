import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		
		// 자릿수가 한자리인 소수는 반드시 2,3,5,7로 한정된다.
		int num[] = {2,3,5,7};
		for(int i=0; i<num.length; i++) {
			calc(num[i], N);
		}
		System.out.println(sb);
	}
	
	static void calc(int number, int N) {
		// 탈출조건은 재귀를 통해 자릿수가 모두 채워지면 끝내도록 한다.
		if(N==1) {
			sb.append(number+"\n");
			return;
		}
		else {
			// 다음 자릿수는 홀수에 대해서만 검사한다.
			for(int i=1; i<=9; i+=2) {
				int update = (number*10)+i;
				// System.out.println(update+" : "+N);
				// 새로 생성한 수가 소수인 경우, 다음 자릿수에 대한 검사를 수행한다.
				if(isPrime(update)) {			
					// 재귀함수 호출에 들어가는 매개변수에는 전위, 후위 증감 연산을 수행하지 말자.
					// 해당 함수 내에서 매개변수의 자체 값이 바뀌게 되면서 다음 번 연산에 영향을 미치게 된다.
					// calc(update, --N); (X)
					calc(update, N-1);
				}
			}
		}
	}
	
	static boolean isPrime(int number) {
		for(int i=2; i*i<=number; i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
}
