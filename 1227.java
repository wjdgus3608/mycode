import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static int ret;
	public static void bfs() {
		Queue<Point> q=new LinkedList<>();
		q.add(new Point(1,1));
		visit[1][1]=true;
		boolean flag=true;
		while(!q.isEmpty() && flag) {
			Point cur=q.poll();
			for(int i=0; i<4; i++) {
				int nexty=cur.y+dy[i];
				int nextx=cur.x+dx[i];
				if(visit[nexty][nextx]) continue;
				if(map[nexty][nextx]==0) {
					visit[nexty][nextx]=true;
					q.add(new Point(nexty,nextx));
				}
				if(map[nexty][nextx]==3) {
					ret=1;
					flag=false;
					break;
				}
			}	
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int k=0; k<10; k++) {
			T=Integer.valueOf(br.readLine());
			map=new int[100][100];
			visit=new boolean[100][100];
			for(int i=0; i<100; i++) {
				String temp=br.readLine();
				for(int j=0; j<100; j++) {
					map[i][j]=Character.getNumericValue(temp.charAt(j));
				}
			}
			bfs();
			System.out.print("#"+(k+1)+" ");
			System.out.println(ret);
			ret=0;
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
