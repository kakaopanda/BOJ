import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int array[] = new int[3];
		for(int i=0; i<3; i++) {
			array[i] = s.nextInt();
		}
		Arrays.sort(array);
		for(int num : array) {
			System.out.print(num+" ");
		}
	}
}