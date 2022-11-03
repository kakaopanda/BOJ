import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sum = 0;
		int n = s.nextInt();
		String str = s.next();
		char array[] = str.toCharArray();
		for(int i=0; i<n; i++) {
			sum += array[i]-'0';
		}
		System.out.println(sum);
	}
}
