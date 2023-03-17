import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N;
	static HashMap<Integer,Integer> map = new HashMap<>();
	static int ret;
	static boolean[] visit;
	static TreeSet<Integer> list = new TreeSet<>();
	
	public static void dfs(int depth, int start, int cur) {
		if(start==cur && visit[cur]) {
			
				
				int key = start;
				while(map.get(key)!=start) {
					list.add(key);
					key=map.get(key);
				}
				list.add(key);
			
			
			return;
		}
		
		if(visit[cur]) return;
		visit[cur]=true;
		dfs(depth+1,start,map.get(cur));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			map.put(i, Integer.parseInt(br.readLine()));
		}
		
		for(int i=1; i<=N; i++) {
			visit=new boolean[N+1];
			if(map.get(i)!=i)
				dfs(0,i,i);
		}
		
		for(int i=1; i<=N; i++) {
			if(map.get(i)==i) {
				list.add(i);
			}
		}
		
		
		
		bw.write((list.size())+"\n");
		for(int num:list)
		bw.write(num+"\n");
		bw.flush();
		
		br.close();
		bw.close();
	}
}
