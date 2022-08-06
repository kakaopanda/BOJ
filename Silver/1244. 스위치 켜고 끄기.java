import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 
 * 0 1 0 1 0 0 0 1
 * 남학생이 3을 전달받으면, 3번과 6번을 토글한다. -> 0 1 1 1 0 1 0 1
 * 여학생이 3을 전달받으면, 2번과 4번의 인덱스를 조사한다.
 * 2번과 4번의 상태가 다른 경우, 3번만 토글한다.
 * 2번과 4번의 상태가 같은 경우, 1번과 5번의 상태도 조사한다.
 */
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = s.nextInt(); // 스위치 개수
		int array[] = new int[n]; // 스위치의 상태를 기록할 배열
		for(int i=0; i<array.length; i++) {
			array[i] = s.nextInt();
		}
		int student = s.nextInt(); // 학생 수
		int info[][] = new int[student][2];
		for(int i=0; i<student; i++) {
			info[i][0] = s.nextInt();
			info[i][1] = s.nextInt();
		}
		
		// Arrays.copyOfRange(info, 0, info.length-1)
		// 2차원 배열에 대해 copyOfRange()를 사용할 경우, int[]의 주소값이 전달되므로 값에 의한 복사가 이뤄지지 않게 된다.
		int value[] = new int[student];
		for(int i=0; i<student; i++) {
			value[i] = info[i][1];
		}
		
		for(int i=0; i<student; i++) {
			// 남학생인 경우
			if(info[i][0]==1) {
				for(int j=0; j<n; j++) {
					if(j==info[i][1]-1) {
						array[j] = Math.abs(array[j] - 1);
						info[i][1] += value[i];
					}
				}
			}
			
			// 여학생인 경우
			else if(info[i][0]==2) {
				// 본인의 스위치를 토글한다.
				for(int j=0; j<n; j++) {
					if(j==info[i][1]-1) {
						array[j] = Math.abs(array[j] - 1);
					}
				}
				int index = 1;
				while(true) {
					// 토글을 수행하려는 범위가 스위치의 범위를 초과하지 않는지 검사한다.
					if((info[i][1]-index-1>=0) && (info[i][1]+index-1<n)) {
						// 여학생이 받은 번호를 중심으로, 양 옆의 스위치 상태가 동일한 경우 토글한다.
						if(array[info[i][1]-index-1]==array[info[i][1]+index-1]) {
							array[info[i][1]-index-1] = Math.abs(array[info[i][1]-index-1] - 1);
							array[info[i][1]+index-1] = Math.abs(array[info[i][1]+index-1] - 1);
							index++;
						}
						// 여학생이 받은 번호를 중심으로, 양 옆의 스위치 상태가 동일하지 않은 경우, 토글을 중단한다.
						else {
							break;
						}
					}
					else {
						break;
					}
				}
			}
		}
		// 출력 형식을 잘 봐야한다.. 한 줄에 20개씩을 출력하고, 다음 스위치는 다음 줄 맨 앞에 출력한다.
		int line = 1;
		for(int i=0; i<n; i++, line++) {
			sb.append(array[i]);
			if(line==20) {
				sb.append("\n");
				line -= 20;
			}
			else {
				if(i!=n-1) {
					sb.append(" ");
				}
			}
		}
		System.out.println(sb);
	}
}
