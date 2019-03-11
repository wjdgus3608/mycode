import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
1. 각각의 칸은 벽 또는 빈 칸이다. 
2. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다.
3. 지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.
4. 로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
5. 첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다.
6. 로봇 청소기가 청소하는 칸의 개수를 출력한다.

1. 현재 위치를 청소한다.
2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
	(1) 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
	(2) 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
	(3) 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
	(4) 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
*/
public class Main {
	static int N,M,dir,count=0;
	static int[][] map;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static Queue<Dot> q=new LinkedList<>();
	public static void bfs(Dot start)
	{
		map[start.y][start.x]=2;
		count++;
		q.offer(start);
		int check=0;
		while(!q.isEmpty())
		{
			Dot temp=q.poll();
				int nextY,nextX;
				switch(dir)
				{
				case 0:
					dir=2;
					break;
				case 1:
					dir=3;
					break;
				case 2:
					dir=1;
					break;
				case 3:
					dir=0;
					break;
				}
				nextY=temp.y+dy[dir];
				nextX=temp.x+dx[dir];
				if(map[nextY][nextX]!=0)
				{
					check++;
					//(3) 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
					if(check==4)
					{
						check=0;
						switch(dir)
						{
						case 0:
							nextY=temp.y+dy[1];
							nextX=temp.x+dx[1];
							break;
						case 1:
							nextY=temp.y+dy[0];
							nextX=temp.x+dx[0];
							break;
						case 2:
							nextY=temp.y+dy[3];
							nextX=temp.x+dx[3];
							break;
						case 3:
							nextY=temp.y+dy[2];
							nextX=temp.x+dx[2];
							break;
						}
						//(4) 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
						if(map[nextY][nextX]==1)
						{
							System.out.print(count);
							return;
						}
						q.offer(new Dot(nextY,nextX));
						continue;
					}
					q.offer(temp);
					continue;
				}
				check=0;
				q.offer(new Dot(nextY,nextX));
				map[nextY][nextX]=2;
				count++;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.valueOf(st.nextToken());
		M=Integer.valueOf(st.nextToken());
		//5. 첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다.
		map=new int[N][M];
		st=new StringTokenizer(br.readLine()," ");
		Dot start=new Dot(Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()));
		dir=Integer.valueOf(st.nextToken());
		switch(dir)
		{
		case 0:
			break;
		case 1:
			dir=3;
			break;
		case 2:
			dir=1;
			break;
		case 3:
			dir=2;
			break;
		}
		for(int i=0; i<N; i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++)
				map[i][j]=Integer.valueOf(st.nextToken());
		}
		bfs(start);
		
	}
}
class Dot{
	int x;
	int y;
	Dot(int y, int x)
	{
		this.y=y;
		this.x=x;
	}
}
