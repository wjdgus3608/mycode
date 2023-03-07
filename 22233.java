import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			String key = br.readLine();
			set.add(key);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(),",");
			while(st.hasMoreTokens()) {
				String key = st.nextToken();
				if(set.contains(key))
					set.remove(key);
			}
			sb.append(set.size()).append("\n");
		}
		
		System.out.println(sb);
	}
}
