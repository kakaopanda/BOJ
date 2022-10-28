import java.util.*;

public class Main{
	public static void main(String[] args){
		int testcase=0;
		Scanner s = new Scanner(System.in);
        testcase = s.nextInt();
		for(int i=0; i<testcase; i++){
			int a, b;
			a = s.nextInt();
			b = s.nextInt();
			System.out.println(a+b);
		}
	}
}