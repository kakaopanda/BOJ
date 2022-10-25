import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count[] = new int[26];
		int location[] = new int[26];
		String str = s.next();
		char input[] = str.toCharArray();
		for(int i=0; i<location.length; i++) {
			location[i] = -1;
		}
		for(int i=0; i<input.length; i++) {
			count[input[i]-'a']++;
		}
		for(int i=0; i<count.length; i++) {
			if(count[i]!=0) {
				for(int j=0; j<input.length; j++) {
					if(input[j]=='a'+i) {
						if(location[i]==-1) {
							location[i] = j;
						}
					}
				}
			}
		}
		for(int i=0; i<location.length; i++) {
			System.out.print(location[i]+" ");
		}
	}
}
