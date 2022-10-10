import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
        int N, M;
        while(s.hasNext()){
            N = s.nextInt();
            M = s.nextInt();
            System.out.println((M)/(N+1));
        }
	}
}
