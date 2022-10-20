import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		
		for(int i=0; i<testCase; i++){
			String str = s.next();
			int score = 0;
			int count = 1;
			char array[] = str.toCharArray();
			for(int j=0; j<array.length; j++){
				if(array[j]=='O')
					score += count++;
				else
					count = 1;
			}
			System.out.println(score);
		}
	}
}