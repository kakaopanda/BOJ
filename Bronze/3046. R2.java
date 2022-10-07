import java.util.*;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int first = s.nextInt();
		int average = s.nextInt();
		int second = average*2 - first;
		System.out.println(second);
	}
}