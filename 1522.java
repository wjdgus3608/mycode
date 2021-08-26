
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int ret, g, s;
	static String W,S;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		g = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		W=br.readLine();
		S=br.readLine();
		
		HashMap<Character,Integer> gmap = new HashMap<>();
		for(char c : W.toCharArray()) {
			gmap.put(c, gmap.getOrDefault(c, 0)+1);
		}
		
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0; i<s; i++) {
			if(i>=g) {
				map.put(S.charAt(i-g), map.get(S.charAt(i-g))-1);
			}
			map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0)+1);
			if(i>=g-1 && map.get(S.charAt(i))==gmap.getOrDefault(S.charAt(i),0)) {
				if(check(map,gmap)) {
					ret++;
				}
			}
		}
		
		
		System.out.println(ret);
	}
	public static boolean check(HashMap<Character,Integer> map, HashMap<Character,Integer> gmap) {
		for(char key : gmap.keySet()) {
			if(gmap.get(key)!=map.getOrDefault(key, 0)) {
				return false;
			}
		}
		
		return true;
	}

}
