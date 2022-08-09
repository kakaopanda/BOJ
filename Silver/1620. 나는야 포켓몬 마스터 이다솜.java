import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<Integer, String> value_map = new HashMap<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String str = st.nextToken();
			map.put(str,(i+1));
			value_map.put((i+1), str);
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String str = st.nextToken();
			char array[] = str.toCharArray();
			boolean check = true;
			
			// 사용자의 입력이 숫자인지, 문자열인지 검증한다.
			for(int j=0; j<array.length; j++) {
				if(!Character.isDigit(array[j])) {
					check = false; 
				}
			}
			// 사용자의 입력이 숫자인 경우
			if(check) {
				int search = Integer.parseInt(str);
				sb.append(value_map.get(search)+"\n");
			}
			// 사용자의 입력이 문자인 경우
			else {
				sb.append(map.get(str)+"\n");
			}
		}
		System.out.println(sb);
	}
}
