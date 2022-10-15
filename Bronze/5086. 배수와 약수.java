import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		do {
			int x = s.nextInt();
			int y = s.nextInt();
			if(x==0 && y==0) {
				break;
			}
			else {
				String result;
				if(y%x==0) {
					result = "factor";
					System.out.println(result);
					continue;
				}
				if(x%y==0) {
					result ="multiple";
					System.out.println(result);
					continue;
				}
				result = "neither";
				System.out.println(result);
			}
		}while(true);
	}
}
