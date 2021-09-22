
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int N,ret = Integer.MAX_VALUE;
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(N,0));
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(cur.num==1) {
				ret = cur.cnt;
				return;
			}
			
			if(cur.num%3==0)
				q.add(new Point(cur.num/3,cur.cnt+1));
			if(cur.num%2==0)
				q.add(new Point(cur.num/2,cur.cnt+1));
			q.add(new Point(cur.num-1,cur.cnt+1));
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.println(ret);
	}
	
}

class Point{
	int num,cnt;
	Point(int num, int cnt){
		this.num=num;
		this.cnt=cnt;
	}
}



