import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int array[] = new int[n];
		int index = 0;
		for(int i=1; i<n; i++) {
			if(summation(i)==n) {
				array[index] = i;
				index++;
				break;
			}
			else {
				continue;
			}
		}
		Arrays.sort(array);
		if(array[n-1]==0)
			System.out.println(0);
		else {
			int min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				if(array[i]!=0 && array[i]<min)
					min = array[i];
			}
			System.out.println(min);
		}		
	}
	static int summation(int n) {
		int number = n;
		char array[] = Integer.toString(number).toCharArray();
		int sum = n;
		for(int i=0; i<array.length; i++) {
			sum += array[i]-'0';
		}
		return sum;
	}
}