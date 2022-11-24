import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N; // 신청한 동아리의 수
	static int S; // 팀원 3명의 능력합에 대한 가입조건
	static int M; // 개인 능력치에 대한 가입조건
	static List<Integer> list = new ArrayList<>(); // 스마트클럽에 가입이 허용된 학생들의 리스트
	static int student[]; // 스마트클럽에 가입하려는 학생들의 입력 값을 담는 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		// 정수 N, S, M에 대한 입력 값을 받는다.
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 각 동아리별로 신청하려는 학생들의 능력치를 입력 받은 뒤, 가입 가능한 동아리를 판별한다.
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			student = new int[3];
			int total = 0;
			boolean check = true;
			
			for(int i=0; i<3; i++) {
				student[i] = Integer.parseInt(st.nextToken());
				// Case1. 클럽에 가입하려는 학생이 개인 능력치가 M 미만인 경우, 가입이 거부된다.
				if(student[i] < M) {
					check = false;
				}
				else {
					total += student[i];
				}
			}
			
			if(!check) {
				continue;
			}
			else {
				// Case2. 클럽에 가입하려는 3명의 문제해결능력의 합이 S미만인 경우, 가입이 거부된다.
				if(total < S) {
					continue;
				}
				// Case3. 문제해결능력의 합 조건과 개인의 최소 능력치 조건을 모두 만족한 경우, 스마트클럽 가입을 허용한다.
				else {
					for(int i=0; i<3; i++) {
						list.add(student[i]);
					}
				}
			}
		}
		// 첫째 줄에 스마트클럽 가입이 가능한 동아리의 수를 출력한다.
		sb.append(list.size()/3+"\n");
		
		// 둘재 줄에 스마트클럽에 가입된 학생들의 능력치를 입력 받은 순서대로 공백으로 구분하여 출력한다.
		for(int i=0; i<list.size(); i++) {
			if(i==list.size()-1) {
				sb.append(list.get(i)+"\n");
			}
			else {
				sb.append(list.get(i)+" ");				
			}
		}
		System.out.println(sb);
	}
}
