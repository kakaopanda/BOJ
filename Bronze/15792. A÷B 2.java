import java.util.*;
import java.math.*;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		BigDecimal a,b;
		a = s.nextBigDecimal();
		b = s.nextBigDecimal();
		System.out.println(a.divide(b,1000,BigDecimal.ROUND_HALF_UP));
	}
}