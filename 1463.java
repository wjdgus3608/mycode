
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

	
	static int N,ret;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N+1];
		if(N==1) {
			System.out.println(0);
			return;
		}
		else if(N<=3) {
			System.out.println(1);
			return;
		}
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		for(int i=4; i<=N; i++) {
			dp[i] = Math.min(i%2==0?dp[i/2]:Integer.MAX_VALUE,Math.min(i%3==0?dp[i/3]:Integer.MAX_VALUE, dp[i-1]))+1;
		}
		
		System.out.print(dp[N]);
		
	}
	
}



