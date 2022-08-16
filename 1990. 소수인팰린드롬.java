import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		for(int i=A; i<=B; i++) {
			String str = Integer.toString(i);
			char[] array = str.toCharArray();
			boolean check = true;
			
			for(int j=0; j<array.length/2; j++) {
				if(array[j]!=array[array.length-j-1]) {
					check = false;
					break;
				}
			}
			
			if(check) {
				if(isPrime(i)) {
					sb.append(i+"\n");
				}
			}
		}
		sb.append(-1);
		System.out.println(sb);
	}
	
	static boolean isPrime(int number) {
		if(number==1) {
			return false;
		}
		for(int i=2; i*i<=number; i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
}
