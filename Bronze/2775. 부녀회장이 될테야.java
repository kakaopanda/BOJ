import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		for(int i=0; i<testcase; i++) {
			int k = s.nextInt();
			if(k<1)
				return;
			int n = s.nextInt();
			if(n>14)
				return;
			// k층의 n호에 몇 명의 사람들이 살고있는지 출력한다.
			// 1층의 3호면 0층의 1,2,3호의 합인 6명이 살아야한다.
			// 2층의 3호면 1층의 1,2,3호의 합인 10명이 살아야한다. (1+3+6)
			int room[][] = new int[k+1][n];
			
			// 0층에 대한 정보 초기화
			for(int j=0; j<1; j++) {
				for(int l=0; l<n; l++) {
					room[j][l] = (l+1);
				}
			}
			
			for(int j=1; j<k+1; j++) {
				for(int l=0; l<n; l++) {
					for(int m=0; m<=l; m++) {
						room[j][l] += room[j-1][m];
					}
				}
			}
			System.out.println(room[k][n-1]);
		}
	}
}
