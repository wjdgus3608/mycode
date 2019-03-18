import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,L,R;
	static int ret=0;
	static int sum=0,count =0;
	static int[][]map;
	static int[][]visit;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	public static void bfs(Point start) {
		Queue<Point> q=new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty()) {
			Point temp=q.poll();
			visit[temp.y][temp.x]=1;
			sum+=map[temp.y][temp.x];
			count++;
			for(int i=0; i<4; i++) {
				int nexty=temp.y+dy[i];
				int nextx=temp.x+dx[i];
				if(nexty<0 || nextx<0 || nexty>=N || nextx>=N || visit[nexty][nextx]!=0)
					continue;
				int diff=Math.abs(map[nexty][nextx]-map[temp.y][temp.x]);
				if(diff>=L && diff<=R)
				q.add(new Point(nexty,nextx));
			}
		}
		if(count!=1) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j]==1) {
					map[i][j]=sum/count;
				}
			}
		}	
		ret++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.valueOf(st.nextToken());
		L=Integer.valueOf(st.nextToken());
		R=Integer.valueOf(st.nextToken());
		map=new int[N][N];
		visit=new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++)
				map[i][j]=Integer.valueOf(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j]==0) {
				bfs(new Point(i,j));
				if(count!=1)
				{
					i=-1;
					sum=0;
					count=0;
					visit=new int[N][N];
					break;
				}
				sum=0;
				count=0;
				visit=new int[N][N];
				}
			}
		}
		System.out.print(ret);
	}
}
class Point{
	int x,y;
	Point(int y, int x){
		this.x=x;
		this.y=y;
	}
}
