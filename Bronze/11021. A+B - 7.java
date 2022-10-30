import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int testCase = 0;
		int count = 1;
		testCase = s.nextInt();
		for(int i=0; i<testCase; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			if(a>0 && b<10)
				System.out.println("Case #"+(count++)+": "+(a+b));
		}
	}
}