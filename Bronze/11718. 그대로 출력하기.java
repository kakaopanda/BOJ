import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		do {
			String str = s.nextLine();
			System.out.println(str);
		}while(s.hasNext());
	}
}