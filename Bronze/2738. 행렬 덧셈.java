import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int A[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				A[i][j] = s.nextInt();
			}
		}
		
		int B[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				B[i][j] = s.nextInt();
			}
		}
		
		int result[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				result[i][j] = A[i][j] + B[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}