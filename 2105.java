import java.io.BufferedReader;

public class Main {
	static int T;
	static int N;
	static int ret=-1;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy= {-1,-1,1,1};
	static int[] dx= {-1,1,-1,1};
	public static boolean search(int ga, int se, Point start) {
		visit=new boolean[N][N];
		HashSet<Integer> set=new HashSet<>();
		int nexty=start.y;
		int nextx=start.x;
		for(int i=0; i<ga; i++) {
			nexty+=dy[3];
			nextx+=dx[3];
			if(nexty<0 || nextx<0 || nexty>=N || nextx>=N || visit[nexty][nextx] || set.contains(map[nexty][nextx])) return false;
			set.add(map[nexty][nextx]);
			visit[nexty][nextx]=true;
		}
		for(int i=0; i<se; i++) {
			nexty+=dy[2];
			nextx+=dx[2];
			if(nexty<0 || nextx<0 || nexty>=N || nextx>=N || visit[nexty][nextx] || set.contains(map[nexty][nextx])) return false;
			set.add(map[nexty][nextx]);
			visit[nexty][nextx]=true;
		}
		for(int i=0; i<ga; i++) {
			nexty+=dy[0];
			nextx+=dx[0];
			if(nexty<0 || nextx<0 || nexty>=N || nextx>=N || visit[nexty][nextx] || set.contains(map[nexty][nextx])) return false;
			set.add(map[nexty][nextx]);
			visit[nexty][nextx]=true;
		}
		for(int i=0; i<se; i++) {
			nexty+=dy[1];
			nextx+=dx[1];
			if(nexty<0 || nextx<0 || nexty>=N || nextx>=N || visit[nexty][nextx] || set.contains(map[nexty][nextx])) return false;
			set.add(map[nexty][nextx]);
			visit[nexty][nextx]=true;
		}
		ret=Math.max(set.size(), ret);
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		T=Integer.valueOf(st.nextToken());
		for(int k=0; k<T; k++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.valueOf(st.nextToken());
			map=new int[N][N];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.valueOf(st.nextToken());
				}
			}
			for(int i=N-2; i>0; i--) {
				for(int j=N-2; j>0; j--) {
					for(int a=0; a<N; a++) {
						for(int b=0; b<N; b++) {
							search(i,j,new Point(a,b));
						}
					}
					
				}
			}
			System.out.print("#"+(k+1)+" ");
			System.out.println(ret);
			ret=-1;
		}
	}
}
class Point{
	int x,y;
	Point(int y,int x){
		this.y=y;
		this.x=x;
	}
}
