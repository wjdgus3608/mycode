import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N,K;
	static int ret;
	static final int maxV = 200003;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N>=K) {
			System.out.println(N-K);
			return;
		}
		
		int[] dp =new int[maxV];
		Arrays.fill(dp, maxV);
		dp[N]=0;
		int cur = N;
		if(N==0) {
			dp[1]=1;
			cur = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(cur);
		
		while(!q.isEmpty()) {
			int num=q.poll();
			if(num>=maxV) continue;
			
			if(num*2<maxV && dp[num*2]>dp[num]) {
				dp[num*2]=dp[num];
				q.add(num*2);
			}
			if(num-1>=0 && dp[num-1]>dp[num]+1) {
				dp[num-1]=dp[num]+1;
				q.add(num-1);
			}
			if(num+1<maxV && dp[num+1]>dp[num]+1) {
				dp[num+1]=dp[num]+1;
				q.add(num+1);
			}
		}
		bw.write(Integer.toString(dp[K]));
		bw.flush();
		bw.close();
		br.close();
	}
}
