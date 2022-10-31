import java.util.*;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int numerator = 1;
		int denominator = 1;
		
		for(int i=n; i>n-k; i--)
			numerator *= i;
		
		for(int i=1; i<=k; i++)
			denominator *= i;
		
		System.out.println(numerator/denominator);
	}
}