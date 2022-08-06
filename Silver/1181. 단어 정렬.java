import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Map<String,Integer> hashmap = new HashMap<>();
		for(int i=0; i<n; i++) {
			String str = s.next();
			hashmap.put(str, Integer.valueOf(str.length()));
		}
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hashmap.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
			    @Override
			    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
			    	if(o1.getValue()!=o2.getValue())
			    		return o1.getValue() - o2.getValue();
			    	else
			    		return o1.getKey().compareTo(o2.getKey());
			    }
		});
		for(int i=0; i<entryList.size(); i++) {
			System.out.println(entryList.get(i).getKey());
		}
	}
}