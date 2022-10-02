import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int first = s.nextInt();
		String first_str = Integer.toString(first);
		char first_array[] = first_str.toCharArray();
		char new_array[] = new char[first_array.length];
		int index = 0;
		for(int i=first_array.length-1; i>=0; i--) {
			new_array[i] = first_array[index++];
		}
		int new_first = Integer.parseInt(new String(new_array));
		int second = s.nextInt();
		String second_str = Integer.toString(second);
		char second_array[] = second_str.toCharArray();
		index = 0;
		for(int i=second_array.length-1; i>=0; i--) {
			new_array[i] = second_array[index++];
		}
		int new_second = Integer.parseInt(new String(new_array));
		if(new_first > new_second)
			System.out.println(new_first);
		else
			System.out.println(new_second);
	}
}