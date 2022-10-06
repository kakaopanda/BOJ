import java.util.Scanner;

public class Main {
	static boolean check = false;
	static int input[] = new int[9];
	static int numbers[] = new int[7]; 
	static boolean selected[] = new boolean[9];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for(int i=0; i<9; i++) {
			input[i] = s.nextInt();
		}
		combination(0, 0, 0);
	}
	
	public static void combination(int cnt, int index, int sum) {
		if(check) {
			return;
		}
		if(cnt == 7) {
			// 조합으로 선정한 7개의 숫자들의 합이 100인 경우
			if(sum==100) {
				for(int i=0; i<7; i++) {
					System.out.println(numbers[i]);
				}
				check = true;
				return;
			}
		}
		else {
			for(int i=index; i<9; i++) {
				if(!selected[i]) {
					selected[i] = true;
					numbers[cnt] = input[i];
					combination(++cnt, index+1, sum+input[i]);
					selected[i] = false;
					cnt--;
				}
			}
		}
	}
}
