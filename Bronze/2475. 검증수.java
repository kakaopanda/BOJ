import java.util.*;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int array[] = new int[5];
		int sum = 0;
		
		for(int i=0; i<5; i++){
			array[i] = s.nextInt();
			sum += array[i]*array[i];
		}
			
		while(sum>10){
			sum = sum % 10;
		}
		System.out.println(sum);
	}
}