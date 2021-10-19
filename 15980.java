
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[M][N];
		for(int j=0; j<N; j++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			String nums = st.nextToken();
			for(int i=0; i<nums.length(); i++) {
				int num = Character.getNumericValue(nums.charAt(i));
				arr[i][j]=type.equals("L") ? -num:num;
			}
		}
		
		int[] dp = new int[M];
		int[] sums = new int[M];
		int max = Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				sum+=arr[i][j];
			}
			if(i!=0)
				dp[i]=dp[i-1]+sum;
			else
				dp[i]=sum;
			sums[i]=sum;
//			System.out.print(dp[i]+" ");
		}
		Queue<Pair> q = new LinkedList<>();
		
		boolean flag = false;
		for(int j=0; j<N; j++) {
			int[] trans = new int[M];
			trans[0]=sums[0]-arr[0][j];
			int tmp_max = Math.abs(trans[0]);
			for(int i=1; i<M; i++) {
				trans[i]=trans[i-1]+sums[i]-arr[i][j];
				tmp_max = Math.max(tmp_max, Math.abs(trans[i]));
			}
			if(j==0) {
				q.add(new Pair(0,tmp_max));
			}
			if(tmp_max<max) {
				q.poll();
				q.add(new Pair(j+1,tmp_max));
				max = tmp_max;
				flag=true;
			}
			else if(flag && tmp_max==max) {
				Pair pre = q.peek();
				if(pre.index>j+1) {
					q.poll();
					q.add(new Pair(j+1,tmp_max));
				}
			}
		}
		
		System.out.println(q.peek().index);
		System.out.println(q.peek().num);
		
		br.close();
	}
	
}

class Pair{
	int index,num;
	Pair(int index, int num){
		this.index = index;
		this.num = num;
	}
}




