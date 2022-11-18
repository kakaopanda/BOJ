import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();

		int A[] = new int[3];
		int B[] = new int[3];
		int C[] = new int[3];
		
		for(int i=0; i<A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<C.length; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}
		
		B[0] = C[0] - A[2];
		B[1] = C[1] / A[1];
		B[2] = C[2] - A[0];
		for(int i=0; i<C.length; i++) {
			System.out.print(B[i]+" ");
		}
	}
}
