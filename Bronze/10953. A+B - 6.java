import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		StringTokenizer st;
		String str;
		int testCase = s.nextInt();
		for(int i=0; i<testCase; i++){
			str = s.next();
			st = new StringTokenizer(str,",");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(a+b);
		}
		s.close();
	}
}