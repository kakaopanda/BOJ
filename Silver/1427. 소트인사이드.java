import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		// 입력으로는 BufferedReader를 이용하고, 출력으로는 StringBuilder를 이용한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		char array[] = str.toCharArray();
		Integer sorted_array[] = new Integer[array.length];
		for(int i=0; i<array.length; i++) {
			sorted_array[i] = array[i]-'0';
		}
		Arrays.sort(sorted_array, Collections.reverseOrder());
		for(int i=0; i<array.length; i++) {
			System.out.print(sorted_array[i]);
		}
	}
}
