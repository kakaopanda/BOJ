import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int paper[][] = new int[100][100];
		int color[][] = new int[T][2];
		int area = 0;
		for(int t=0; t<T; t++) {
			for(int i=0; i<2; i++) {
				color[t][i] = s.nextInt();
			}
			for(int i=color[t][0]; i<color[t][0]+10; i++) {
				for(int j=color[t][1]; j<color[t][1]+10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j] == 1) {
					area++;
				}
			}
		}
		System.out.println(area);
	}
}
