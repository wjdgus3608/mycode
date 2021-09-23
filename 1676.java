
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

	
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N+1];
		if(N<5) {
			System.out.println(0);
			return;
		}
		dp[0]=0;
		dp[1]=0;
		for(int i=2; i<=N; i++) {
			int num = i;
			int cnt = 0;
			while(num%5==0) {
				num/=5;
				cnt++;
			}
			dp[i]=dp[i-1]+cnt;
		}
		System.out.println(dp[N]);
		
	}
	
}



