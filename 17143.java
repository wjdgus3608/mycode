import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C,M;
	static int[][] map;
	static Queue<fish> q=new LinkedList<>();
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,1,-1};
	public static void move() {
		int size=q.size();
		for(int i=0; i<size; i++) {
			fish cur=q.poll();
			int dis=cur.speed;
			int nexty=cur.y;
			int nextx=cur.x;
			while(dis>0){
				nexty+=dy[cur.dir-1];
				nextx+=dx[cur.dir-1];
				if(nexty==0 || nextx==0 || nexty==R+1 || nextx==C+1) {
					nexty-=2*dy[cur.dir-1];
					nextx-=2*dx[cur.dir-1];
					switch(cur.dir) {
					case 1:
						cur.dir=2;
						break;
					case 2:
						cur.dir=1;
						break;
					case 3:
						cur.dir=4;
						break;
					case 4:
						cur.dir=3;
						break;
					}
				}
				dis--;
			}
			if(map[cur.y][cur.x]!=0)
			map[cur.y][cur.x]--;
				map[nexty][nextx]++;
				q.add(new fish(nexty,nextx,cur.speed,cur.dir,cur.size));
		}
		for(int k=0; k<size; k++) {
			fish cur=q.poll();
			int i=cur.y;
			int j=cur.x;
			if(map[i][j]>1) {
			while(map[i][j]>1) {
			fish temp=q.poll();
			while(temp.y!=i || temp.x!=j) {
				q.add(temp);
				temp=q.poll();
			}
			if(cur.size<temp.size) {
				cur=temp;
				i=cur.y;
				j=cur.x;
			}
			map[i][j]--;
			}
			q.add(cur);
			k=-1;
			size=q.size();
			}
			else{
				q.add(cur);
			}
		}
		return;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		R=Integer.valueOf(st.nextToken());
		C=Integer.valueOf(st.nextToken());
		M=Integer.valueOf(st.nextToken());
		map=new int[R+1][C+2];
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int r,c,s,d,z;
			r=Integer.valueOf(st.nextToken());
			c=Integer.valueOf(st.nextToken());
			s=Integer.valueOf(st.nextToken());
			d=Integer.valueOf(st.nextToken());
			z=Integer.valueOf(st.nextToken());
			q.add(new fish(r,c,s,d,z));
			map[r][c]=1;
		}
		
		int time=1,ret=0;
		while(time<C+1) {
			int depth=1;
			boolean check=true;
			while(map[depth][time]!=1) {
				depth++;
				if(depth==R+1) {
					check=false;
					break;
				}
			}
			if(check) {
				int size=q.size();
				for(int i=0; i<size; i++) {
					fish cur=q.poll();
					if(cur.y==depth && cur.x==time) {
						ret+=cur.size;
						map[cur.y][cur.x]=0;
						break;
					}
					else {
						q.add(cur);
					}
				}
			}
			move();
			time++;
		}
		System.out.println(ret);
	}
}

class fish{
	int x,y;
	int speed;
	int dir;
	int size;
	fish(int y, int x, int speed, int dir, int size){
		this.y=y;
		this.x=x;
		this.speed=speed;
		this.dir=dir;
		this.size=size;
	}
}
