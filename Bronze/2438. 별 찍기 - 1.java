import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		
		if(count >= 1 && count <= 100){
			for(int i=1; i<=count; i++){
				for(int j=i; j>0; j--)
					System.out.print("*");
				System.out.println();
			}
		}
	}
}