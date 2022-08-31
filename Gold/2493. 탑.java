import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(st.nextToken()); 
		Stack<Tower> stack = new Stack<>();

		st = new StringTokenizer(br.readLine()," ");
		int max_height = 0;
		
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			stack.add(new Tower(input, i+1));
			
			// 현재까지 존재하는 탑의 최고 높이보다 입력 값이 더 큰 경우, 해당 탑의 신호는 어떤 탑에게도 닿지 않는다.
			if(max_height < input) {
				// 탑의 최대 높이를 갱신한다.
				max_height = input;
				bw.write(0+" ");
			}
			
			// 현재까지 존재하는 탑의 최고 높이보다 입력 값이 작은 경우, 신호 전송 방향(탑 생성의 역방향)으로 신호가 닿는 탑을 탐색한다.
			else {
				for(int j=stack.size()-2; j>=0; j--) {
					if(stack.get(j).height < input) {
						// 현재 추가된 탑보다 이전에 생성된 탑의 높이가 더 낮을 경우, 어차피 신호를 받을 수 없기 때문에 제거한다.
						stack.remove(j);
					}
					else {
						bw.write(stack.get(j).no+" ");
						break;
					}
				}
			}
		}
		bw.flush();
	}
	
	static class Tower{
		int height;
		int no;
		public Tower(int height, int no) {
			this.height = height;
			this.no = no;
		}
	}
}
