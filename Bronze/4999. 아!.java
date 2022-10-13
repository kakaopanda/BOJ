import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		String me = st.nextToken();
		st = new StringTokenizer(br.readLine()," ");
		String doctor = st.nextToken();
		
		if(me.length() >= doctor.length()) {
			sb.append("go");
		}
		else {
			sb.append("no");
		}
		
		System.out.println(sb);
	}
}
