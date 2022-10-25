import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int array[] = new int[N];
		int count = 0;
		for(int i=0; i<N; i++) {
			array[i] = s.nextInt();
		}
		int v = s.nextInt();
		for(int i=0; i<N; i++) {
			if(v==array[i])
				count++;
		}
		System.out.println(count);
	}
}