import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int R,C;
	static char[][] arr;
	static int JY,JX;
	static int FY,FX;
	static boolean[][] visitF;
	static boolean[][] visitJ;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static int ret = Integer.MAX_VALUE;
	static Queue<Point> fq = new LinkedList<>();
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		
		
		
		q.add(new Point(JY,JX,1));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			Point fcur = null;
			while(!fq.isEmpty() && fq.peek().time<=cur.time) {
				fcur=fq.poll();
				for(int i=0; i<4; i++) {
					int nexty = fcur.y+dy[i];
					int nextx = fcur.x+dx[i];
					if(nexty<0 || nextx<0 || nexty>=R || nextx>=C || visitF[nexty][nextx]) continue;
						
					if(arr[nexty][nextx]!='#') {
						arr[nexty][nextx]='F';
						visitF[nexty][nextx]=true;
						fq.add(new Point(nexty,nextx,fcur.time+1));
					}
						
				}
			}
			
			
			for(int i=0; i<4; i++) {
				int nexty = cur.y+dy[i];
				int nextx = cur.x+dx[i];
				if(nexty<0 || nextx<0 || nexty>=R || nextx>=C || visitJ[nexty][nextx]) continue;
				if(arr[nexty][nextx]=='.' &&(nexty==0 || nextx==0 || nexty==R-1 || nextx==C-1)) {
					ret = cur.time+1;
					return;
				}
				if(arr[nexty][nextx]=='.') {
					visitJ[nexty][nextx]=true;
					q.add(new Point(nexty,nextx,cur.time+1));
				}
				
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		visitF = new boolean[R][C];
		visitJ = new boolean[R][C];
	
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				char c = str.charAt(j);
				arr[i][j]=c;
				if(c=='J') {
					JY=i;
					JX=j;
					visitJ[i][j]=true;
				}
				else if(c=='F') {
					FY=i;
					FX=j;
					fq.add(new Point(FY,FX,1));
					visitF[i][j]=true;
				}
			}
		}
		if(JY==0 || JY==R-1 || JX==0 || JX==C-1) {
			System.out.println(1);
			return;
		}
		bfs();
		
		bw.write((ret==Integer.MAX_VALUE?"IMPOSSIBLE":Integer.toString(ret)));
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Point{
	int y,x,time;
	Point(int y, int x, int time){
		this.y=y;
		this.x=x;
		this.time=time;
	}
}
