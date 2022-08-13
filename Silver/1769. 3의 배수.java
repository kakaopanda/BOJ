import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String x = s.next();
		char array[] = x.toCharArray();
		
		int count = 0;
		boolean check = true;
		
		while(true) {
			if(array.length==1) {
				break;
			}
			else {
				count++;
				int sum = 0;
				for(int i=0; i<array.length; i++) {
					sum += array[i]-'0';
				}
				array = Integer.toString(sum).toCharArray();
			}
		}
		System.out.println(count);
		if(array[0]%3==0) {
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}
