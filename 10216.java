import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int T,N;
	static ArrayList<Point> list=new ArrayList<>();
	static int ret;
	static ArrayList<ArrayList<Integer>> result=new ArrayList<>();
	static boolean[] visit;
	public static boolean check(Point cur, Point other) {
		double a=(cur.r);
		double b=(other.r);
		double c=Math.abs(cur.y-other.y)*Math.abs(cur.y-other.y)+Math.abs(cur.x-other.x)*Math.abs(cur.x-other.x);
		if(((a+b)*(a+b))>=c)
			return true;
		else
			return false;
	}
	public static void dfs(int index) {
		visit[index]=true;
		for(int i=0; i<result.get(index).size(); i++) {
			if(!visit[result.get(index).get(i)]) {
				visit[result.get(index).get(i)]=true;
				dfs(result.get(index).get(i));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T=Integer.valueOf(st.nextToken());
		for(int k=0; k<T; k++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.valueOf(st.nextToken());
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int x=Integer.valueOf(st.nextToken());
				int y=Integer.valueOf(st.nextToken());
				int r=Integer.valueOf(st.nextToken());
				list.add(new Point(y,x,r));
			}
			for(int i=0; i<N; i++) {
				ArrayList<Integer> temp=new ArrayList<>();
				result.add(temp);
			}
			for(int i=0; i<list.size()-1; i++) {
				Point cur=list.get(i);
				for(int j=i+1; j<list.size(); j++) {
					Point other=list.get(j);
					if(check(cur,other)) {
						result.get(i).add(j);
						result.get(j).add(i);
					}
				}
			}
			visit=new boolean[N];
			for(int i=0; i<result.size(); i++)
			{
				if(!visit[i]) {
					dfs(i);	
					ret++;
				}		
			}
			System.out.println(ret);
			ret=0;
			list.clear();
			result.clear();
		}
	}
}

class Point{
	int x,y;
	int r;
	Point(int y,int x,int r){
		this.y=y;
		this.x=x;
		this.r=r;
	}
}
