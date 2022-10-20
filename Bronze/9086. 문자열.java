import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int i=0; i<T; i++) {
			String str = s.next();
			char array[] = str.toCharArray();
			System.out.print((char)array[0]+""+(char)array[array.length-1]);
			System.out.println();
		}
	}
}