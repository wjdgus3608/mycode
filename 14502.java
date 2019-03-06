import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void dfs(int[][] copy,boolean[][] visit,int i,int j)
	{
		if(visit[i][j] || copy[i][j]==1)
			return;
		visit[i][j]=true;
		if(copy[i][j]==0)
			copy[i][j]=2;
		if(i-1>=0)
		dfs(copy,visit,i-1,j);
		if(i+1<copy.length)
			dfs(copy,visit,i+1,j);
		if(j-1>=0)
			dfs(copy,visit,i,j-1);
		if(j+1<copy[i].length)
			dfs(copy,visit,i,j+1);
	}
	public static int check(int[][] copy)
	{
		int count=0;
		for(int i=0; i<copy.length; i++)
		{
			for(int j=0; j<copy[i].length; j++)
			{
				if(copy[i][j]==0)
					count++;
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.valueOf(st.nextToken());
		int M=Integer.valueOf(st.nextToken());
		int[][] map=new int[N][M];
		LinkedList<LinkedList<Integer>> vir=new LinkedList<>();
		for(int i=0; i<N; i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++)
			{
				map[i][j]=Integer.valueOf(st.nextToken());
				if(map[i][j]==2)
				{
					LinkedList<Integer> l=new LinkedList<>();
					l.add(i);
					l.add(j);
					vir.add(l);
				}
			}
		}
		int max=Integer.MIN_VALUE;
		int[][] copy=new int[N][M];
		LinkedList<LinkedList<Integer>> list=new LinkedList<>();
		for(int a=0; a<N*M-2; a++)
		{
			if(map[a/M][a%M]!=0)
				continue;
			for(int b=a+1; b<N*M-1; b++)
			{
				if(map[b/M][b%M]!=0)
					continue;
				for(int c=b+1; c<N*M; c++)
				{
					if(map[c/M][c%M]==0)
					{
						LinkedList<Integer> temp=new LinkedList<>();
						temp.add(a);
						temp.add(b);
						temp.add(c);
						list.add(temp);
					}
				}
			}
		}
		for(int i=0; i<list.size(); i++)
		{
			for(int a=0; a<map.length; a++) {
				for(int b=0; b<map[a].length; b++) {
					copy[a][b]=map[a][b];
				}
			}
			copy[list.get(i).get(0)/M][list.get(i).get(0)%M]=1;
			copy[list.get(i).get(1)/M][list.get(i).get(1)%M]=1;
			copy[list.get(i).get(2)/M][list.get(i).get(2)%M]=1;
			boolean[][] visit=new boolean[N][M];
			for(int a=0; a<vir.size(); a++)
			{
				if(!visit[vir.get(a).get(0)][vir.get(a).get(1)])
					dfs(copy,visit,vir.get(a).get(0),vir.get(a).get(1));
			}
			max=Math.max(max,check(copy));
		}
		System.out.println(max);
	}
}
