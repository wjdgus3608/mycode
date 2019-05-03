import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, number=0;
	static int[][]map;
	static boolean[][]visit;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static Queue<Dot> q=new LinkedList<>();
	public static int bfs() {
		int count=1;
		while(!q.isEmpty())
		{
			Dot temp=q.poll();
			for(int i=0; i<4; i++)
			{
				int nextY=temp.y+dy[i];
				int nextX=temp.x+dx[i];
				if(nextX<0 || nextY<0 || nextX>=N || nextY>=N || visit[nextY][nextX])
					continue;
				if(map[nextY][nextX]==1)
				{
					q.offer(new Dot(nextY,nextX));
					visit[nextY][nextX]=true;
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.valueOf(br.readLine());
		map=new int[N][N];
		visit=new boolean[N][N];
		for(int i=0; i<N; i++)
		{
			String temp=br.readLine();
			for(int j=0; j<N; j++)
				map[i][j]=Character.getNumericValue(temp.charAt(j));
		}
		LinkedList<Integer> list=new LinkedList<>();
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(!visit[i][j] && map[i][j]==1)
				{
					number++;
					q.offer(new Dot(i,j));
					visit[i][j]=true;
					list.add(bfs());
				}
			}
		}
		System.out.println(number);
		Collections.sort(list);
		for(int temp:list)
			System.out.println(temp);
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
