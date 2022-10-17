import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int K = s.nextInt();
		for(int k=0; k<K; k++) {
			sb.append("Class "+(k+1)+"\n");
			int N = s.nextInt();
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int score[] = new int[N];
			for(int i=0; i<N; i++) {
				score[i] = s.nextInt();
				if(min > score[i]) {
					min = score[i];
				}
				if(max < score[i]) {
					max = score[i];
				}
			}
			Arrays.sort(score);
			int gap = Integer.MIN_VALUE;
			for(int i=N-1; i>0; i--) {
				if(score[i]-score[i-1] > gap) {
					gap = score[i]-score[i-1];
				}
			}
			sb.append("Max "+max+", Min "+min+", Largest gap "+gap+"\n");
		}
		System.out.println(sb);
	}
}