
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
    
		Scanner s = new Scanner(System.in);
		
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		
		if((a>=100 && a<1000)&&(b>=100 && b<1000)&&(c>=100 && c<1000)){
			long result = a*b*c;
			String str = Long.toString(result);
			int array[] = new int[10];
			for(int i=0; i<str.length(); i++){
				int index = Character.getNumericValue(str.charAt(i));
				array[index]++;
			}
			for(int i=0; i<10; i++)
				System.out.println(array[i]);
		}
	}
}