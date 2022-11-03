import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	// Scanner는 시간초과로 사용하지 못한다.
	public static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if(str.equals("add")||str.equals("check")||str.equals("remove")||str.equals("toggle")) {
				int arg = Integer.parseInt(st.nextToken());
				
				switch(str) {
				case "add":
					set.add(arg);
					break;
				case "remove":
					set.remove(arg);
					break;
				case "check":
					if(set.contains(arg)) {
						sb.append(1+"\n");
					}
					else {
						sb.append(0+"\n");
					}
					break;
				case "toggle":
					if(set.contains(arg)) {
						set.remove(arg);
					}
					else {
						set.add(arg);
					}
					break;
				default:
				}
			}
			else {
				switch(str) {
				case "all":
					set.clear();
					for(int j=1; j<=20; j++) {
						set.add(j);
					}
					break;
				case "empty":
					set.clear();
					break;
				default:
				}
			}
		}
		System.out.println(sb);
	}
}
