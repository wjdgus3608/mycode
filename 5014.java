import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int F,S,G,U,D;
	static int ret=-1;
	static int[] dx = {-1,1};
	static HashSet<Integer> visit = new HashSet<>();
	
	public static void bfs() {
		Queue<Point> q= new LinkedList<>();
		q.add(new Point(S,0));
		visit.add(S);
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i=0; i<2; i++) {
				int nextx = cur.x+dx[i]*(i==0?D:U);
				if(nextx<1 || nextx>F || visit.contains(nextx)) continue;
				
				if(nextx==G) {
					ret = cur.dis+1;
					return;
				}
				
				visit.add(nextx);
				q.add(new Point(nextx,cur.dis+1));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		if(S==G) {
			System.out.println(0);
			return;
		}
		bfs();
		
		System.out.println((ret==-1?"use the stairs":ret));
	}
}

class Point{
	int x,dis;
	Point(int x, int dis){
		this.x=x;
		this.dis=dis;
	}
}
