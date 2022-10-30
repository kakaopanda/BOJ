import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int a, b;
		a = s.nextInt();
		b = s.nextInt();
		
		if(a>0 && b<10)
			System.out.println(a*b);
	}
}