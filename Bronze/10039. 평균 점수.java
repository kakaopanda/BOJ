import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int avg = 0;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			if(N<40) {
				avg += 40;
			}
			else {
				avg += N;
			}
		}
		System.out.println((int)avg/5);
	}
}
