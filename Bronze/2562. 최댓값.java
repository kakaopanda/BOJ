import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int array[] = new int[9];
		for(int i=0; i<9; i++){
			array[i] = s.nextInt();
		}
		int max = array[0];
		int index = 0;
		for(int i=1; i<9; i++){
			if(max < array[i]){
				max = array[i];
				index = i;
			}
		}
		System.out.println(max);
		System.out.println(index+1);
	}
}