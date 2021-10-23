
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
	static int V,E,K;
	static ArrayList<Point>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		
		for(int i=0; i<V+1; i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Point(v,w));
		}
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K]=0;
		
		PriorityQueue<Point> q = new PriorityQueue<>((a,b)->{
			return Integer.compare(a.dis, b.dis);
		});
		q.add(new Point(K,0));
		boolean[] visit = new boolean[V+1];
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(visit[cur.num]) continue;
			visit[cur.num]=true;
			for(Point now:list[cur.num]) {
				if(visit[now.num]) continue;
				if(dist[now.num]>dist[cur.num]+now.dis) {
					dist[now.num]=dist[cur.num]+now.dis;
					q.add(new Point(now.num,dist[now.num]));
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<V+1; i++) {
			if(dist[i]==Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(dist[i]+"\n");
		}
		
		System.out.print(sb.toString());
		
		br.close();
	}
	
}

class Point{
	int num, dis;
	Point(int num, int dis){
		this.num=num;
		this.dis=dis;
	}
}





