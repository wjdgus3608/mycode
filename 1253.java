import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N;
	static TreeMap<Long, Integer> map = new TreeMap<>();
	static int ret;
	
	public static boolean check(long num) {
		for(long key:map.keySet()) {
			if(map.containsKey(num-key)) {
				if(num==key && map.get(num)<3) continue;
				if(num==(num-key)) {
					if(num==0 && map.get(num)>2) return true;
					else if(num!=0 && map.get(num)>1) return true;
				}
				else if(key==(num-key)) {
					if(map.get(key)>1) return true;
				}
				else
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			long key = Integer.parseInt(st.nextToken());

			map.put(key, map.getOrDefault(key, 0)+1);
		}
		
		for(long key:map.keySet()) {
			if(check(key)) {
				
				ret+=map.get(key);
			}
		}
	
		bw.write(Integer.toString(ret));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
