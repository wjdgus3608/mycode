import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static ArrayList<HashMap<String,Integer>> words = new ArrayList<>();
	
	static int max=0, min=Integer.MAX_VALUE;
	static TreeSet<String> maxSet = new TreeSet<>();
	static TreeSet<String> minSet = new TreeSet<>();
	static String maxStr="",minStr="";
	
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str="";
		while(!(str=br.readLine()).equals("-")) {
			words.add(new HashMap<String,Integer>());
			HashMap<String,Integer> map = words.get(words.size()-1);
			for(char c:str.toCharArray()) {
				String s = Character.toString(c);
				int value = 0;
				if(map.containsKey(s)) {
					value = map.get(s);
				}
				map.put(s, value+1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!(str=br.readLine()).equals("#")) {
			HashMap<String,Integer> map = new HashMap<>();
			for(char c:str.toCharArray()) {
				String s = Character.toString(c);
				int value=0;
				if(map.containsKey(s)) {
					value=map.get(s);
				}
				
				map.put(s, value+1);
			}
			
			check(map);
			
			for(String s:minSet)
				minStr+=s;
			for(String s:maxSet)
				maxStr+=s;
			
			sb.append(minStr).append(" ").append(min).append(" ").append(maxStr)
			.append(" ").append(max).append("\n");
			
			max = 0;
			min=Integer.MAX_VALUE;
			maxSet.clear();
			minSet.clear();
			minStr="";
			maxStr="";
		}
		
		System.out.print(sb);
	}
	
	public static void check(HashMap<String,Integer> map) {
		for(String key:map.keySet()) {
			String center = key;
			int cnt=0;
			for(HashMap<String,Integer> temp:words) {
				if(!temp.containsKey(center)) continue;
				boolean isValid = true;
				for(String s:temp.keySet()) {
					if(!map.containsKey(s) || temp.get(s)>map.get(s)) {
						isValid=false;
						break;
					}
				}
				if(isValid) {
					cnt++;
				}
			}
			
			if(cnt<=min) {
				if(cnt!=min) {
					minSet.clear();
				}
				min=cnt;
				minSet.add(center);
			}
			if(cnt>=max) {
				if(cnt!=max) {
					maxSet.clear();
				}
				max=cnt;
				maxSet.add(center);
			}
		}
	}
}
