import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int a, b;
		a = s.nextInt();
		b = s.nextInt();
		if((a>=1 && a<=10000) && (b>=1 && b<=10000)){
			System.out.println(a+b);
			System.out.println(a-b);
			System.out.println(a*b);
			System.out.println(a/b);
			System.out.println(a%b);
		}
	}
}