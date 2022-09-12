import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		for(int i=0; i<testcase; i++) {
			int iteration = s.nextInt();
			String str = s.next();
			char array[] = str.toCharArray();
			for(int j=0; j<array.length; j++) {
				for(int k=0; k<iteration; k++) {
					System.out.print(array[j]);
				}
			}
			System.out.println();
		}
	}
}
