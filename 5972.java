import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N,M;
	static ArrayList[] list;
	static boolean[] visit;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		dist = new int[N];
		for(int i=0; i<N; i++)
			list[i]=new ArrayList<Point>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		visit = new boolean[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int dis = Integer.parseInt(st.nextToken());
			
			list[start].add(new Point(end,dis));
			list[end].add(new Point(start,dis));
		}
		
		PriorityQueue<Point> q = new PriorityQueue<>((a,b)->Integer.compare(a.dis, b.dis));
		dist[0]=0;
		q.add(new Point(0,0));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(visit[cur.end]) continue;
			visit[cur.end]=true;
			
			for(int i=0; i<list[cur.end].size(); i++) {
				Point next = (Point)list[cur.end].get(i);
				
				if(dist[cur.end]==Integer.MAX_VALUE) continue;
				if(dist[cur.end]+next.dis<dist[next.end]) {
					dist[next.end]=dist[cur.end]+next.dis;
					q.add(new Point(next.end,dist[next.end]));
				}
			}
		}
		
		bw.write(Integer.toString(dist[N-1]));
		bw.flush();
		bw.close();
		br.close();
	}
}

class Point{
	int end,dis;
	Point(int end, int dis){
		this.end=end;
		this.dis=dis;
	}
}
