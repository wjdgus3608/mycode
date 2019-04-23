import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	static int ret=Integer.MAX_VALUE;
	static ArrayList<Point> list=new ArrayList<>();
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	public static void bfs() {
		Queue<Point> q=new LinkedList<>();
		visit=new boolean[N][N];
		int[][] temp=new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) {
					visit[i][j]=true;
					q.add(new Point(i,j));
				}
				temp[i][j]=map[i][j];
			}
		}
		
		while(!q.isEmpty()) {
			Point cur=q.poll();
			for(int i=0; i<4; i++) {
				int nexty=cur.y+dy[i];
				int nextx=cur.x+dx[i];
				if(nexty<0 || nextx<0 || nexty>=N || nextx>=N || visit[nexty][nextx]) continue;
				if(temp[nexty][nextx]==-3 || temp[nexty][nextx]==-1) {
					visit[nexty][nextx]=true;
					if(temp[nexty][nextx]==-1)
					check(temp);
					temp[nexty][nextx]=temp[cur.y][cur.x]+1;
					q.add(new Point(nexty,nextx));
				}
			}
		}
		check(temp);
	}
	public static void check(int[][] temp) {
		int max=Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(temp[i][j]==-3) return;
				max=Math.max(max, temp[i][j]);
			}
		}
		ret=Math.min(ret, max);
		return;
	}
	public static void dfs(int index, int cnt) {
		if(cnt==M) {
			bfs();
			return;
		}
		for(int i=index+1; i<list.size(); i++) {
			Point cur=list.get(i);
			map[cur.y][cur.x]=0;
			dfs(i,cnt+1);
			map[cur.y][cur.x]=-1;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.valueOf(st.nextToken());
		M=Integer.valueOf(st.nextToken());
		map=new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.valueOf(st.nextToken());
				if(map[i][j]==2) {
					list.add(new Point(i,j));
					map[i][j]=-1;
				}
				else if(map[i][j]==1) {
					map[i][j]=-2;
				}
				else {
					map[i][j]=-3;
				}
			}
		}
		dfs(-1,0);
		if(ret==Integer.MAX_VALUE)
			System.out.println(-1);
		else
		System.out.println(ret);
	}
}

class Point{
	int x,y;
	Point(int y, int x){
		this.y=y;
		this.x=x;
	}
}
