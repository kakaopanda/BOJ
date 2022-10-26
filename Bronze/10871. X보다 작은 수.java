import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int compare = s.nextInt();
		
		int array[] = new int[size];
		for(int i=0; i<size; i++)
			array[i] = s.nextInt();
		
		for(int i=0; i<size; i++)
			if(array[i] < compare)
				System.out.print(array[i]+" ");
	}
}