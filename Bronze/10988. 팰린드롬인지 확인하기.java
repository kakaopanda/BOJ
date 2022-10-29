
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String str = st.nextToken();
		char[] array = str.toCharArray();
		boolean check = true;
			
		for(int j=0; j<array.length/2; j++) {
			if(array[j]!=array[array.length-j-1]) {
				check = false;
				break;
			}
		}
			
		if(check) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
}
