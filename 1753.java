
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V,E,K;
	static long[] dist;
	static HashMap<Integer,Long>[] map;
	public static void solve() {
		PriorityQueue<Point> q= new PriorityQueue<>((a,b)->{
			return Long.compare(a.dis, b.dis);
		});
		
		q.add(new Point(K,0));
		boolean[] visit = new boolean[V+1];
		dist[K]=0;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(visit[cur.num]) continue;
			visit[cur.num]=true;
			for(int key:map[cur.num].keySet()) {
				
				if(dist[key]>dist[cur.num]+map[cur.num].get(key)) {
					dist[key]=dist[cur.num]+map[cur.num].get(key);
					
				q.add(new Point(key,dist[key]));
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		 map = new HashMap[V+1];
		for(int i=0; i<V+1; i++) {
			map[i]=new HashMap<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			
			map[u].put(v, Math.min(map[u].getOrDefault(v, Long.MAX_VALUE), w));
			
		}
		dist = new long[V+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		solve();
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			sb.append((dist[i]!=Long.MAX_VALUE ? dist[i]:"INF")+"\n");
		}
		System.out.print(sb.toString());
		
	}

}

class Point{
	int num;
	long dis;
	Point(int num, long dis){
		this.num=num;
		this.dis = dis;
	}
}

