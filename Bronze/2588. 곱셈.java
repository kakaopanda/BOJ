import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		String first = s.next();
		char first_array[] = first.toCharArray();
		String second = s.next();
		char second_array[] = second.toCharArray();
		int first_sum = 0;
		for(int i=0, mul=100; i<3; i++, mul/=10) {
			first_sum += (first_array[i]-'0')*mul*(second_array[2]-'0');
		}
		
		int second_sum = 0;
		for(int i=0, mul=100; i<3; i++, mul/=10) {
			second_sum += (first_array[i]-'0')*mul*(second_array[1]-'0');
		}
		
		int third_sum = 0;
		for(int i=0, mul=100; i<3; i++, mul/=10) {
			third_sum += (first_array[i]-'0')*mul*(second_array[0]-'0');
		}
		
		System.out.println(first_sum);
		System.out.println(second_sum);
		System.out.println(third_sum);
		int sum = third_sum*100+second_sum*10+first_sum;
		System.out.println(sum);
	}
}