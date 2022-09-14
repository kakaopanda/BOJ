import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n;
		n = s.nextInt();
		
		for(int i=1; i<10; i++){
			System.out.println(n+" * "+i+" = "+n*i);
		}
	}
}