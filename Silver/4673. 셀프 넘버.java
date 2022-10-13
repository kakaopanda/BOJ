import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int array[] = new int[100000];
		for(int i=1; i<10001; i++) {
			array[self(i)] = 1;
		}
		for(int i=1; i<10001; i++) {
			if(array[i]!=1) {
				System.out.println(i);	
			}
		}
	}
	static int self(int n) {
		String s = Integer.toString(n);
		char array[] = s.toCharArray();
		int sum = n;
		for(int i=0; i<array.length; i++) {
			sum += array[i]-'0';
		}
		return sum;
	}
}