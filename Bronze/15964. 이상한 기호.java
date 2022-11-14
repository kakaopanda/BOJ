import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		long A = s.nextLong();
		long B = s.nextLong();
		System.out.println((A+B)*(A-B));
	}
}