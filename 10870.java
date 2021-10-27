
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N==0 || N==1) {
			System.out.println(N);
			return;
		}
		dp = new int[N+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2; i<N+1; i++) {
			dp[i]=dp[i-2]+dp[i-1];
		}
		System.out.println(dp[N]);
	}

}
