import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Stack으로 구현하면 시간초과 걸린다..
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		
		// Stack에 1..N까지의 요소를 넣어준다.
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		while(true) {
			if(queue.size()==1) {
				break;
			}
			else {
				queue.remove(queue.peek()); // 맨 위에 위치한 카드를 버린다.
				// 그 다음에 맨 위에 위치한 다시 추가하여 맨 아래로 옮긴뒤에 지운다.
				queue.add(queue.poll());
			}
		}
		System.out.println(queue.peek());
	}
}
