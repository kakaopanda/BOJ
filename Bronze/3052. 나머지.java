import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int n[] = new int[10];
		int remainder[] = new int[10];
		for(int i=0; i<10; i++) {
			n[i] = s.nextInt();
			if(n[i]<0 || n[i]>1000)
				return;
			remainder[i] = n[i]%42;
		}
		for(int i=0; i<10; i++) {
			for(int j=i+1; j<10; j++) {
				if(remainder[i]==remainder[j]) {
					remainder[j] = -1;
				}
			}
		}
		int count = 0;
		for(int i=0; i<10; i++) {
			if(remainder[i]>=0)
				count++;
		}
		System.out.println(count);
	}
}