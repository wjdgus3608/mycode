
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		PriorityQueue<Point> q = new PriorityQueue<>((a,b)->{
			if(a.x==b.x) {
				return Integer.compare(a.y, b.y);
			}
			return Integer.compare(a.x, b.x);
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.add(new Point(x,y));
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			sb.append(cur.x+" "+cur.y+"\n");
		}
		
		System.out.print(sb.toString());
		
		
		br.close();
	}
	
}

class Point{
	int x,y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}






