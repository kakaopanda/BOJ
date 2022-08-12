import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws Exception{
		// 시간초과를 해결하기 위해, BufferedReader와 HashSet을 이용한다.
		// ArrayList는 결과를 담아 정렬하는 것에만 사용한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<String> noListen = new HashSet<>();
		for(int i=0; i<n; i++) {
			noListen.add(br.readLine());
		}
		
		ArrayList<String> noListenNoSee = new ArrayList<>();
		for(int i=0; i<m; i++) {
			str = br.readLine();
			if(noListen.contains(str)) {
				noListenNoSee.add(str);
			}
		}
		Collections.sort(noListenNoSee);
		System.out.println(noListenNoSee.size());
		for(String s : noListenNoSee) {
			System.out.println(s);
		}
	}
}