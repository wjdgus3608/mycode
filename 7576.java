import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int count=0;
	static int[][] visit;
	static int[][] map;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static Queue<Dot> q=new LinkedList<>();
	public static int bfs() {
		while(!q.isEmpty())
		{
			Dot temp=q.poll();
			for(int i=0; i<4; i++)
			{
				int nextX=temp.x+dx[i];
				int nextY=temp.y+dy[i];
				if(nextX<0 || nextY<0 || nextX>=M || nextY>=N || visit[nextY][nextX]!=0)
					continue;
				if(map[nextY][nextX]==0) {
					q.offer(new Dot(nextY,nextX));
					map[nextY][nextX]=1;
					visit[nextY][nextX]=visit[temp.y][temp.x]+1;
					count--;
					if(count==0)
						return visit[nextY][nextX]-1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		M=Integer.valueOf(st.nextToken());
		N=Integer.valueOf(st.nextToken());
		map=new int[N][M];
		visit=new int[N][M];
		for(int i=0; i<N; i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++)
			{
				int temp=Integer.valueOf(st.nextToken());
				map[i][j]=temp;
				if(temp==1)
				{
					visit[i][j]=1;
					q.offer(new Dot(i,j));
				}
				else if(temp==0)
					count++;
			}
		}
		if(count==0)
		{
			System.out.print(0);
			return;
		}
		int result=bfs();
		System.out.print(result);
	}
}
class Dot{
	int x;
	int y;
	Dot(int y, int x)
	{
		this.x=x;
		this.y=y;
	}
}
