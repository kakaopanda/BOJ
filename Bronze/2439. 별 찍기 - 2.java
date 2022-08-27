import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				System.out.print(" ");
			}
			for(int j=i+1; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}