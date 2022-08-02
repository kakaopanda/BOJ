import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		int w = s.nextInt();
		int h = s.nextInt();
		
		int up = y;
		int down = h-y;
		int left = x;
		int right = w-x;

		int array[] = new int[4];
		array[0] = up;
		array[1] = down;
		array[2] = left;
		array[3] = right;
		
		Arrays.sort(array);
		System.out.println(array[0]);
	}
}
