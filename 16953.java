
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int ret=Integer.MAX_VALUE;
	public static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(cur.num==N) {
				ret = cur.cnt;
				return;
			}
			if(cur.num*2<=N) {
				q.add(new Point(cur.num*2,cur.cnt+1));
			}
			Long next = Long.parseLong(Long.toString(cur.num)+"1");
			if(next<=N) {
				q.add(new Point(next,cur.cnt+1));
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		bfs(new Point(num,0));
		
		System.out.println(ret==Integer.MAX_VALUE ? -1 : ret+1);
		
	}

}

class Point{
	long num;
	int cnt;
	Point(long num, int cnt){
		this.num=num;
		this.cnt=cnt;
	}
}
