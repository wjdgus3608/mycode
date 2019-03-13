import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	/*
1. �౸�� ���� ���Ŀ� �ϰ� �ǹ� ������ �ƴϴ�. ???
2. �౸�� �ϱ� ���� ���� ����� �� N���̰� N�� ¦���̴�.
3. ���� N/2������ �̷���� ��ŸƮ ���� ��ũ ������ ������� ������ �Ѵ�.
4. ������� ��ȣ�� 1���� N������ �����߰�, �Ʒ��� ���� �ɷ�ġ�� �����ߴ�.
5. �ɷ�ġ Sij�� i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�̴�.
6. ���� �ɷ�ġ�� ���� ���� ��� ���� �ɷ�ġ Sij�� ���̴�. 
7. Sij�� Sji�� �ٸ� ���� ������, i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�� Sij�� Sji�̴�.
8.��ŸƮ ���� �ɷ�ġ�� ��ũ ���� �ɷ�ġ�� ���̸� �ּҷ� �Ϸ��� �Ѵ�.
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