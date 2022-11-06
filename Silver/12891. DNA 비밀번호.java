import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 부분문자열의 길이
		st = new StringTokenizer(br.readLine()," ");
		String dna = st.nextToken();
		char dna_array[] = dna.toCharArray();
		st = new StringTokenizer(br.readLine()," ");

		// 부분문자열에 포함되어야 할 A, C, G, T의 최소 개수
		//                    1, 0, 0, 1
		// GATA -> GA(X) AT(O), TA(O)
		int need_dna[] = new int[4];
		for(int i=0; i<4; i++) {
			need_dna[i] = Integer.parseInt(st.nextToken());
		}
		
		int possible = 0;
		// 4 2 -> 부분문자열의 검사는 3번만 진행된다.
		int count_dna[] = new int[4];
		
		for(int j=0; j<P; j++) {
			switch(dna_array[j]) {
				case 'A':
					count_dna[0]++;
					break;
				case 'C':
					count_dna[1]++;
					break;
				case 'G':
					count_dna[2]++;
					break;
				case 'T':
					count_dna[3]++;
					break;
			}
		}
		
		boolean check = true;
		for(int j=0; j<4; j++) {
			if(need_dna[j]<=count_dna[j]) {
				continue;
			}
			else {
				check = false;
				break;
			}
		}
		
		if(check) {
			possible++;
		}
		
		for(int i=0; i<S-P; i++) {
			// 맨 처음 검사는 전체 부분문자열 크기만큼 한번 보고, 다음 검사부터는 맨 앞 요소를 제거하고 다음 요소만 본다.
			check = true;
			switch(dna_array[i]) {
			case 'A':
				count_dna[0]--;
				break;
			case 'C':
				count_dna[1]--;
				break;
			case 'G':
				count_dna[2]--;
				break;
			case 'T':
				count_dna[3]--;
				break;
			}
			
			switch(dna_array[i+P]) {
			case 'A':
				count_dna[0]++;
				break;
			case 'C':
				count_dna[1]++;
				break;
			case 'G':
				count_dna[2]++;
				break;
			case 'T':
				count_dna[3]++;
				break;
			}
			
			for(int j=0; j<4; j++) {
				if(need_dna[j]<=count_dna[j]) {
					continue;
				}
				else {
					check = false;
					break;
				}
			}
			if(check) {
				possible++;
			}
		}
		bw.write(String.valueOf(possible));
		bw.flush();
	}
}
