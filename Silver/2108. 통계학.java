import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		// Collections.sort(array)는 메모리 초과로 인해 사용할 수 없다.
		// 입력으로는 BufferedReader를 이용하고, 출력으로는 StringBuilder를 이용한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int array[] = new int[n];
		int sum = 0; // Case1. 산술평균
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
			sum += array[i];
		}
		Arrays.sort(array);
		double avg = (int) Math.round(((double)sum/n)*10/10.0); 
		
		int median = array[n/2]; // Case2. 중앙값
		int mode = 0; // Case3. 최빈값
		
		// 정수의 범위는 -4000 ~ 4000이다.
		int frequency[] = new int[8001];
		int max_frequency = 0;
		for(int i=0; i<array.length; i++) {
			frequency[array[i]+4000]++;
		}
		for(int i=0; i<frequency.length; i++) {
			if(max_frequency<frequency[i])
				max_frequency = frequency[i];
		}
		ArrayList<Integer> arraylist = new ArrayList<>();
		for(int i=0; i<frequency.length; i++) {
			if(max_frequency==frequency[i])
				arraylist.add(i-4000);
		}
		Collections.sort(arraylist);
		if(arraylist.size()>1) {
			mode = arraylist.get(1);
		}
		else {
			mode = arraylist.get(0);
		}
		

		int range = 0; // Case4. 범위
		if(n==1) {
			range = 0;
		}
		else {
			range = array[n-1] - array[0];
		}
		
		sb.append((int)avg).append("\n");
		sb.append(median).append("\n");
		sb.append(mode).append("\n");
		sb.append(range).append("\n");
		System.out.println(sb);
	}
}
