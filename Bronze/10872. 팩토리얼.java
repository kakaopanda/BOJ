import java.util.*;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum = 1;
		for(int i=n; i>0; i--){
			sum *= i;
		}
		System.out.println(sum);
	}
}