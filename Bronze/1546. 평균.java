import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		if(N<0 || N>1000)
			return;
		int score[] = new int[N];
		for(int i=0; i<N; i++) {
			score[i] = s.nextInt();
			if(score[i]<0 || score[i]>100)
				return;
		}
		Arrays.sort(score);
		int M = score[N-1];
		double new_score[] = new double[N];
		double avg = 0;
		for(int i=0; i<N; i++) {
			new_score[i] = (score[i]/(double)M)*100;
			avg += new_score[i];
		}
		System.out.println(avg/N);
	}
}