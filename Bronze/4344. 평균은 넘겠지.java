import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int C = s.nextInt();
		for(int i=0; i<C; i++) {
			int n = s.nextInt(); // 학생들의 수
			int score[] = new int[n];
			double avg = 0;
			for(int j=0; j<n; j++) {
				score[j] = s.nextInt();
				avg += score[j];
			}
			avg /= n;
			int student = 0;
			for(int j=0; j<n; j++) {
				if(score[j]>avg)
					student++;
			}
			System.out.println(String.format("%.3f", ((double)student/n)*100)+"%");
		}
	}
}