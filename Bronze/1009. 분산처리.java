import java.util.*;
import java.math.*;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int testCase = 0;
		testCase = s.nextInt();
		for(int i=0; i<testCase; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			
			if((a>0&&a<100) && (b>0&&b<1000000)){
				int data = 1;
				for(int j=0; j<b; j++)
					data = (data*a)%10;
				
				if(data==0)
					data = 10;
				
				System.out.println(data);
			}
		}
	}
}