import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> map = new HashMap<>();
		int N = s.nextInt();
		for(int i=0; i<N; i++) {
			String name = s.next();
			String record = s.next();
			if(record.equals("enter")) {
				map.put(name, record);
			}
			else if(record.equals("leave")) {
				map.remove(name);
			}
		}
		String array[] = new String[map.size()];
		int index = 0;
		for(String key : map.keySet()) {
			array[index++] = key;
		}
		Arrays.sort(array, Collections.reverseOrder());
		for(String key : array) {
			System.out.println(key);
		}
	}
}