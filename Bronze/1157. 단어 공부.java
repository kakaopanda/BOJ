import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count[] = new int[26];
		String str = s.next();
		char input[] = str.toLowerCase().toCharArray();
		for(int i=0; i<input.length; i++) {
			count[input[i]-'a']++;
		}
		int max = 0;
		int index = 0;
		char ch = 'a';
		for(int i=0; i<count.length; i++) {
			if(count[i] > max) {
				max = count[i];
			}
		}
		for(int i=0; i<count.length; i++) {
			if(count[i] >= max) {
				index = i;
			}
		}
		ch = (char)('a' + index);
		int duplicate = 0;
		for(int i=0; i<count.length; i++) {
			if(input.length==1) {
				duplicate = 1;
				ch = input[0];
				break;
			}
			else if(count[i]==max)
				duplicate++;
		}
		if(duplicate==1) {
			String print = Character.toString(ch).toUpperCase();
			System.out.println(print);
		}
		else {
			System.out.println("?");
		}
	}
}
