import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		st = new StringTokenizer(str," ");
		int array[] = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int temp = 0;
		int max = 0;
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					temp = array[i]+array[j]+array[k];
					if(max < temp && temp <= m)
						max = temp;
				}
			}
		}
		System.out.println(max);
	}
}