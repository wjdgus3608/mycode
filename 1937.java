
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,ret;
	static int[][] arr;
	static int[][] visit;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static int dfs(Point cur, int cnt) {
		if(visit[cur.y][cur.x]!=0)
			return visit[cur.y][cur.x];
		
		visit[cur.y][cur.x]=1;
		
		for(int i=0; i<4; i++) {
			int nextx = cur.x+dx[i];
			int nexty = cur.y+dy[i];
			if(nexty<0 || nextx<0 || nexty>=n || nextx>=n) continue;
			if(arr[nexty][nextx]>arr[cur.y][cur.x]) {
				visit[cur.y][cur.x]=Math.max(dfs(new Point(nexty,nextx),cnt+1)+1,visit[cur.y][cur.x]);
			}
		}
		
		return visit[cur.y][cur.x];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				ret=Math.max(dfs(new Point(i,j),1),ret);
			}
		}
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
