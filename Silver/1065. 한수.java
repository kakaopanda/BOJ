import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(self(n));
	}
	static int self(int n) {
		int count = 0;
		for(int i=1; i<=n; i++) {
			String s = Integer.toString(i);
			char array[] = s.toCharArray();
			if(i<100) {
				count++;
				continue;
			}
			else {
				int first_diff = array[0] - array[1];
				int second_diff = array[1] - array[2];
				if(first_diff==second_diff) {
					count++;
					continue;
				}
			}
		}
		return count;
	}
}