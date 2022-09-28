import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		// Case1. 3kg 봉지와 5kg 봉지로 정확하게 Nkg을 만들 수 없는 경우
		if(n==4 || n==7) {
			sb.append(-1);
		}
		
		// Case2. 5kg 봉지로 정확하게 Nkg을 만들 수 있는 경우
		else if(n%5==0) {
			sb.append(n/5);
		}
		
		// Case3. 5kg 봉지와 3kg 봉지를 함께 사용하거나, 3kg 봉지만을 사용하여 Nkg을 만들 수 있는 경우
		else if(n%5==1 || n%5==3) {
			sb.append(n/5+1);
		}
		
		// Case4. 3kg 봉지만을 사용하여 Nkg을 만들 수 있는 경우
		else if(n%5==2 || n%5==4) {
			sb.append(n/5+2);
		}
		System.out.println(sb);
	}
}
