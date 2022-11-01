import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Coordinate> arraylist = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			arraylist.add(new Coordinate(x,y));
		}
		Collections.sort(arraylist);
		for(int i=0; i<n; i++) {
			System.out.println(arraylist.get(i));
		}
	}
}

class Coordinate implements Comparable<Coordinate>{
	int x;
	int y;
	Coordinate(){}
	Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Coordinate o) {
		if(this.x == o.x) {
			return this.y - o.y;
		}
		else {
			return this.x - o.x;	
		}
	}
	@Override
	public String toString() {
		return this.x+" "+this.y;
	}
}
