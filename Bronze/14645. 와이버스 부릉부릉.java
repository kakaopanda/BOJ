import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int station = Integer.parseInt(st.nextToken());
			int person = Integer.parseInt(st.nextToken());
		}
		System.out.println("비와이");
	}
}
