import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N,M;
	static int target1, target2;
	static ArrayList[] list;
	static int[] visit;
	static int ret =-1;
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(target1);
		visit[target1]=0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<list[cur].size(); i++) {
				int next = (int)list[cur].get(i);
				if(visit[next]!=-1) continue;
				if(next == target2) {
					ret = visit[cur]+1;
					return;
				}
				visit[next]=visit[cur]+1;
				q.add(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		target1 = Integer.parseInt(st.nextToken())-1;
		target2 = Integer.parseInt(st.nextToken())-1;
		
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		visit = new int[N];
		Arrays.fill(visit, -1);
		for(int i=0; i<N; i++)
			list[i]=new ArrayList<Integer>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			
			list[start].add(end);
			list[end].add(start);
		}
		
		bfs();
		
		System.out.println(ret);
		
	
	}
	
	
	
}
