import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		if(n>=1 && n<=1000000){
			int num = s.nextInt();
			int min = num;
			int max = num;
			for(int i=1; i<n; i++){
				int compare = s.nextInt();
				if(min > compare)
					min = compare;
				if(max < compare)
					max = compare;
			}
			System.out.print(min+" "+max);
		}
	}
}