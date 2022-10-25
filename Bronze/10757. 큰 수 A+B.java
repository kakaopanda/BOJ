import java.util.*;
import java.math.*;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BigInteger a = s.nextBigInteger();
		BigInteger b = s.nextBigInteger();
		System.out.println(a.add(b).toString());
	}
}