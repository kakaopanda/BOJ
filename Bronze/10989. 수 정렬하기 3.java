import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// Collections.sort(array)는 메모리 초과로 인해 사용할 수 없다.
		// 입력으로는 BufferedReader를 이용하고, 출력으로는 StringBuilder를 이용한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int array[] = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		for(int i=0; i<n; i++) {
			sb.append(array[i]).append("\n");
		}
		System.out.println(sb);
	}
}
