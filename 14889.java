import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	/*
1. 축구는 평일 오후에 하고 의무 참석도 아니다. ???
2. 축구를 하기 위해 모인 사람은 총 N명이고 N은 짝수이다.
3. 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
4. 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다.
5. 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다.
6. 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. 
7. Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.
8.스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다.
*/
	static int N;
	static int[][] map;
	static int min=Integer.MAX_VALUE;
	static LinkedList<int[]> list=new LinkedList<>(); 
	public static void combi(int[] res,int index,int n, int r, int target)
	{
		if(r==0)
		{
			int[] temp=new int[res.length];
			for(int i=0; i<res.length; i++)
				temp[i]=res[i];
			list.add(temp);
		}
		else if(target==n)
			return;
		else
		{
			res[index]=target;
			combi(res,index+1,n,r-1,target+1);
			combi(res,index,n,r,target+1);
		}
	}
	public static void swap(int[] arr, int i, int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.valueOf(st.nextToken());
		map=new int[N][N];
		for(int i=0; i<N; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				map[i][j]=Integer.valueOf(st.nextToken());
		}
		int[] res=new int[N/2];
		combi(res,0,N,N/2,0);
		for(int[] temp:list)
		{
			int[] team1=new int[N/2];
			int[] team2=new int[N/2];
			int count=0, index1=0,index2=0;
			while(count<N)
			{
				boolean check=false;
				for(int i=0; i<temp.length; i++)
				{
					if(temp[i]==count)
						check=true;
				}
				if(check)
					team1[index1++]=count;
				else
					team2[index2++]=count;
				count++;
			}
			int sum=0, sum2=0;
			 for(int i=0; i<N/2; i++){
	                for(int j=0; j<N/2; j++){
	                    if(i==j) continue;
	                    sum += map[team1[i]][team1[j]];
	                    sum2 += map[team2[i]][team2[j]];
	                }
	            }
			 min=Math.min(min, Math.abs(sum-sum2));
		}
		System.out.print(min);
	}
}