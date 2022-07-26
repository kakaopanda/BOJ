import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		
		int a = Integer.parseInt(st.nextToken()); // 고정비용
		int b = Integer.parseInt(st.nextToken()); // 가변비용
		int c = Integer.parseInt(st.nextToken()); // 노트북 가격

		if(b>=c)
			System.out.println(-1);
		else
			System.out.println(a/(c-b)+1);
	}
}