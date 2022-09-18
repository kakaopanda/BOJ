import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		char array[] = str.toCharArray();
		for(int i=0; i<array.length; i++) {
			// 해당 문자가 소문자인 경우
			if((array[i] >= 'a') &&(array[i] <= 'z'))
				array[i] = (char)(array[i]-32);
			// 해당 문자가 대문자인 경우
			else
				array[i] = (char)(array[i]+32);
		}
		System.out.println(array);
	}
}