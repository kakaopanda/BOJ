import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		// (a-b)는 달팽이가 하루동안 올라가고, 다시 내려오는 것을 반영했을 때 최종적으로 올라가는 길이이다.
		// 정상에 도달한 뒤에는 미끄러지지 않으므로, 한번 내려가는 길이는 필요하지 않다.
		int day = (v-b) / (a-b);
		if((v-a)%(a-b)!=0) {
			day++;
		}
		System.out.println(day);
		
		/* 
		 * Scanner로 입력을 받아 수행하면 100% 시간초과가 발생한다.
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int v = s.nextInt();
		int day = 0;
		
		 * Case1. 정답은 나오지만 시간 초과로 실패하는 코드
		int distance = 0;
		while(distance < v) {
			day++;
			distance += a;
			if(distance >= v)
				break;
			distance -= b;
		}
		*/
	}
}
