import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum = 0;
		for(int i=0; i<n; i++) {
			String str = s.next();
			char array[] = str.toCharArray();
			if(check(str)) {
				sum++;
			}
		}
		System.out.println(sum);
	}
	static boolean check(String str) {
		boolean[] count = new boolean[26];
		char previous = 0;
		
		for(int i=0; i<str.length(); i++) {
			char now = str.charAt(i);
			// 이전 문자와 현재 문자가 다른 경우
			if(previous != now) {
				// 이전 문자와 현재 문자가 다른데, 현재 문자가 처음 등장한 경우
				if(count[now-'a']==false) {
					count[now-'a']=true;
					previous = now;
				}
				// 이전 문자와 현재 문자가 다른데, 현재 문자가 이미 등장한적이 있는 경우
				else {
					return false;
				}
			}
			// 이전 문자와 현재 문자가 같은 경우
			else {
				continue;
			}
		}
		// 그룹 단어에 해당하는 경우
		return true;
	}
}
