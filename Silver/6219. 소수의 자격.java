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
		int D = Integer.parseInt(st.nextToken());
		int count = 0;
		
		for(int i=A; i<=B; i++) {
			if(isPrime(i)) {
				String str = Integer.toString(i);
				char[] array = str.toCharArray();
				for(int j=0; j<array.length; j++) {
					if(array[j]-'0'==D) {
						count++;
						break;
					}
				}
			}
		}
		sb.append(count);
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
