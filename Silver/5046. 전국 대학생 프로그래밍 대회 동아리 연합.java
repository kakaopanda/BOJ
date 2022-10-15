import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		boolean possible = false;
		int price = Integer.MAX_VALUE;
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int P = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<W; j++) {
				int A = Integer.parseInt(st.nextToken());
				if(A >= N) {
					int value = P * N;
					if(value <= B) {
						possible = true;
						if(price > value) {
							price = value;
						}
					}
				}
			}
		}
		if(possible) {
			System.out.println(price);
		}
		else {
			System.out.println("stay home");
		}
	}
}
