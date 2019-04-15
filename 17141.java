import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static int ret=Integer.MAX_VALUE;
	static int value=Integer.MIN_VALUE;
	static ArrayList<Point> list=new ArrayList<>();
	public static void dfs(int cnt,int index) {
		if(cnt==M) {
			bfs();
			return;
		}
		for(int i=index+1; i<list.size(); i++) {
			Point cur=list.get(i);
			map[cur.y][cur.x]=0;
			dfs(cnt+1,i);
			map[cur.y][cur.x]=-1;
		}
	}
	public static void bfs() {
		Queue<Point> q=new LinkedList<>();
		boolean[][] visit=new boolean[N][N];
		int[][] temp=new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) {
					q.add(new Point(i,j,0));
					visit[i][j]=true;
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
				if(temp[nexty][nextx]==-1) {
					visit[nexty][nextx]=true;
					temp[nexty][nextx]=cur.time+1;
					q.add(new Point(nexty,nextx,cur.time+1));
				}
			}
		}
		check(temp);
	}
	public static boolean check(int[][] temp) {
		  value=Integer.MIN_VALUE;
		  for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				value=Math.max(value, temp[i][j]);
				if(temp[i][j]==-1) {
					value=Integer.MIN_VALUE;
					return false;
				}
			}
		}
		ret=Math.min(ret, value);
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		StringBuilder sb;
		N=Integer.valueOf(st.nextToken());
		M=Integer.valueOf(st.nextToken());
		map=new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				int num=Integer.valueOf(st.nextToken());
				switch(num) {
				case 0:
					map[i][j]=-1;
					break;
				case 1:
					map[i][j]=-2;
					break;
				case 2:
					list.add(new Point(i,j));
					map[i][j]=-1;
					break;
				}
			}
		}
		dfs(0,-1);
		if(ret==Integer.MAX_VALUE)
			ret=-1;
		System.out.println(ret);
	}
}

class Point{
	int x,y,time;
	Point(int y,int x){
		this.y=y;
		this.x=x;
	}
	Point(int y,int x,int time){
		this.y=y;
		this.x=x;
		this.time=time;
	}
}
