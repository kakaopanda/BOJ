import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int array[] = new int[N];
		for(int i=0; i<N; i++) {
			array[i] = s.nextInt();
		}
		Arrays.sort(array);
		int time = 0;
		for(int i=N; i>0; i--) {
			for(int j=0; j<i; j++) {
				time += array[j];
			}
		}
		System.out.println(time);
	}
}
