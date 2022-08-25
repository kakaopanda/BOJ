import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		long N = s.nextLong();
		long M = s.nextLong();
		System.out.println(Math.abs((long)N-M));
	}
}