import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		for(int i=0; i<testcase; i++) {
			int h = s.nextInt();
			int w = s.nextInt();
			int n = s.nextInt();
			int room[][] = new int[h][w];
			for(int k=0; k<h; k++) {
				for(int l=0; l<w; l++) {
					room[k][l] = (k+1)*100+l+1;
				}
			}
			int room_h = 0;
			int room_w = 0;
			while(n>h){
				room_h++;
				n -= h;
			}
			room_w = n-1;
			System.out.println(room[room_w][room_h]);
		}
	}
}
