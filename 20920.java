import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	static int N,M;
	static HashMap<String,Integer> map = new HashMap<>();
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.length()>=M) {
				map.put(str, map.getOrDefault(str, 0)+1);
			}
				
		}
		
		for(String key:map.keySet())
			list.add(key);
		
		
		Collections.sort(list,(a,b)->{
			if(map.get(a)==map.get(b)) {
				if(a.length()==b.length()) {
					return a.compareTo(b);
				}
				return -Integer.compare(a.length(), b.length());
			}
			return -Integer.compare(map.get(a), map.get(b));
		});
		
		for(String str:list)
			sb.append(str).append("\n");
		
		System.out.print(sb);
		
	}
}
