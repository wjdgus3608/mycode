import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	private static boolean[] visit;
	Main(int N){
		visit=new boolean[N];
	}
	public void dfs(int start,int N,int[][] map) {
		if(visit[start])
			return;
		System.out.print(start+1+" ");
		visit[start]=true;
		for(int i=0; i<N; i++)
		{
			if(map[start][i]==1)
				dfs(i,N,map);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.valueOf(st.nextToken());
		int M=Integer.valueOf(st.nextToken());
		int start=Integer.valueOf(st.nextToken())-1;
		int[][] map=new int[N][N];
		for(int i=0; i<M; i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			int temp1=Integer.valueOf(st.nextToken())-1;
			int temp2=Integer.valueOf(st.nextToken())-1;
			map[temp1][temp2]=1;
			map[temp2][temp1]=1;
		}
		Main m=new Main(N);
		m.dfs(start,N,map);
		System.out.println();
		visit=new boolean[N];
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		visit[start]=true;
		while(!q.isEmpty())
		{
			int now=q.poll();
			System.out.print(now+1+" ");
			for(int i=0; i<N; i++)
			{
				if(map[now][i]==1 && !visit[i])
				{
					q.offer(i);
					visit[i]=true;
				}
			}
		}
	}
}
