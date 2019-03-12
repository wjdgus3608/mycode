package study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
1. ������ ĭ�� �� �Ǵ� �� ĭ�̴�. 
2. û�ұ�� �ٶ󺸴� ������ ������, �� ������ ��, ��, ��, ���� �ϳ��̴�.
3. ������ �� ĭ�� (r, c)�� ��Ÿ�� �� �ְ�, r�� �������κ��� ������ ĭ�� ����, c�� �������� ���� ������ ĭ�� �����̴�.
4. �κ� û�ұ�� �̹� û�ҵǾ��ִ� ĭ�� �� û������ ������, ���� ����� �� ����.
5. ù° �ٿ� ���� ũ�� N�� ���� ũ�� M�� �־�����.
6. �κ� û�ұⰡ û���ϴ� ĭ�� ������ ����Ѵ�.

1. ���� ��ġ�� û���Ѵ�.
2. ���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
	(1) ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
	(2) ���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
	(3) �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
	(4) �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
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
					//(3) �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
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
						//(4) �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
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
		//5. ù° �ٿ� ���� ũ�� N�� ���� ũ�� M�� �־�����.
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