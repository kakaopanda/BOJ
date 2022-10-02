import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int melody[] = new int[8];
		for(int i=0; i<8; i++) {
			melody[i] = s.nextInt();
		}
		boolean ascend_check = true;
		for(int i=1; i<9; i++) {
			if(i==melody[i-1]) {
				continue;
			}
			else {
				ascend_check = false;
				break;
			}
		}
		if(ascend_check) {
			System.out.println("ascending");
			return;
		}
		boolean descend_check = true;
		if(!ascend_check) {
			int index = 0;
			for(int i=8; i>0; i--) {
				if(i==melody[index++]) {
					continue;
				}
				else {
					descend_check = false;
					break;
				}
					
			}
		}
		if(descend_check){
			System.out.println("descending");
			return;
		}
		if(ascend_check==false && descend_check==false) {
			System.out.println("mixed");
		}
	}
}
