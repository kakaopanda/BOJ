import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int input[];
	static int output[];
	static boolean isSelected[];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		input = new int[N+1];
		output = new int[N+1];
		isSelected = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			input[i] = i;
		}
		perm(1);
	}
	static void perm(int cnt) {
		if(cnt==N+1) {
			for(int i=1; i<=N; i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i=1; i<=N; i++) {
				if(!isSelected[i]) {
					isSelected[i] = true;
					output[cnt] = input[i];
					perm(cnt+1);
					isSelected[i] = false;
				}
			}
		}
	}
}
