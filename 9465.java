import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int T,N;
	static int[][] arr;
	static long ret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[2][N];
			
			for(int y=0; y<2; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0; x<N; x++) {
					arr[y][x]=Integer.parseInt(st.nextToken());
				}
			}
			
			if(N<3) {
				if(N==1) {
					ret = Math.max(arr[0][0], arr[1][0]);
				}
				else {
					ret = Math.max(arr[0][0]+arr[1][1], arr[1][0]+arr[0][1]);
				}
				
				sb.append(ret).append('\n');
				ret=0;
				continue;
			}
			
			
			long[] dp = new long[N*2];
			dp[0]=arr[0][0];
			dp[3]=dp[0]+arr[1][1];
			dp[4]=dp[3]+arr[0][2];
			dp[5]=dp[0]+arr[1][2];
			for(int k=6; k<N*2; k++) {
				if(k%2==0) {
					dp[k]=Math.max(dp[k-1],dp[k-3])+arr[k%2][k/2];
				}
				else {
					dp[k]=Math.max(dp[k-3], dp[k-5])+arr[k%2][k/2];
				}
			}
			
			ret = Math.max(dp[N*2-1], dp[N*2-2]);
			
			dp = new long[N*2];
			dp[1]=arr[1][0];
			dp[2]=dp[1]+arr[0][1];
			dp[5]=dp[2]+arr[1][2];
			dp[4]=dp[1]+arr[0][2];
			for(int k=6; k<N*2; k++) {
				if(k%2==0) {
					dp[k]=Math.max(dp[k-1],dp[k-3])+arr[k%2][k/2];
				}
				else {
					dp[k]=Math.max(dp[k-3], dp[k-5])+arr[k%2][k/2];
				}
			}
			
			ret =Math.max(ret, Math.max(dp[N*2-1], dp[N*2-2]));
			
			sb.append(ret).append('\n');
			ret=0;
		}
		
		
		System.out.println(sb.toString());
	}
}
