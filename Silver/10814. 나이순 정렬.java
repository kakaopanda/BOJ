import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Member> arraylist = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int age = s.nextInt();
			String name = s.next();
			arraylist.add(new Member(i, age, name));
		}
		Collections.sort(arraylist);
		for(int i=0; i<n; i++) {
			System.out.println(arraylist.get(i));
		}
	}
}

class Member implements Comparable<Member>{
	int count;
	int age;
	String name;
	
	Member(int count, int age, String name){
		this.count = count;
		this.age = age;
		this.name = name;
	}
	
	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		if(this.age != o.age) {
			return this.age - o.age;
		}
		else {
			return this.count - o.count;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.age + " " + this.name;
	}
}