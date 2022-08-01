import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int array[] = new int[N];
		for(int i=0; i<N; i++) {
			array[i] = s.nextInt();
		}
		Arrays.sort(array);
		int max = array[N-1];
		int min = array[0];
		
		System.out.println(max*min);
	}
}
