import java.io.BufferedReader;

public class Main {
	static int T;
	static int N,M;
	static int R,C,L;
	static int ret=0;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static boolean[][] dir= {{true,true,true,true},{true,true,false,false},
			{false,false,true,true},
			{true,false,false,true},
			{false,true,false,true},
			{false,true,true,false},
			{true,false,true,false}};
	public static void bfs(Point start) {
		Queue<Point> q=new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			Point cur=q.poll();
			visit[cur.y][cur.x]=true;
			if(cur.time==L) break;
			for(int i=0; i<4; i++) {
				if(!dir[map[cur.y][cur.x]-1][i]) continue;
				int nexty=cur.y+dy[i];
				int nextx=cur.x+dx[i];
				if(nexty<0 || nextx<0 || nexty>=N ||nextx>=M || visit[nexty][nextx]) continue;
				int temp=-1;
				switch(i) {
				case 0:
					temp=1;
					break;
				case 1:
					temp=0;
					break;
				case 2:
					temp=3;
					break;
				case 3:
					temp=2;
					break;
				}
				if(map[nexty][nextx]!=0 && !dir[map[nexty][nextx]-1][temp]) continue;
				if(map[nexty][nextx]!=0) {
					visit[nexty][nextx]=true;
					q.add(new Point(nexty,nextx,cur.time+1));
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j]) ret++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		T=Integer.valueOf(st.nextToken());
		for(int k=0; k<T; k++) {
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.valueOf(st.nextToken());
			M=Integer.valueOf(st.nextToken());
			R=Integer.valueOf(st.nextToken());
			C=Integer.valueOf(st.nextToken());
			L=Integer.valueOf(st.nextToken());
			map=new int[N][M];
			visit=new boolean[N][M];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<M; j++) {
					map[i][j]=Integer.valueOf(st.nextToken());
				}
			}
			bfs(new Point(R,C,1));
			
			System.out.print("#"+(k+1)+" ");
			System.out.println(ret);
			ret=0;
		}
	}
}
class Point{
	int x,y;
	int time;
	Point(int y,int x,int time){
		this.y=y;
		this.x=x;
		this.time=time;
	}
}
