
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static long ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        long[][] arr = new long[n][];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i]=new long[i+1];
            for(int j=0; j<i+1; j++){
                arr[i][j]=Long.parseLong(st.nextToken());
            }
        }

        long[][] dp = new long[n][];
        dp[0] = new long[1];
        dp[0][0]=arr[0][0];
        for(int i=1; i<n; i++){
            dp[i]=new long[i+1];
            for(int j=0; j<i+1; j++){
                if(j-1>=0 && j<dp[i-1].length)
                    dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
                else if(j-1>=0){
                    dp[i][j]=dp[i-1][j-1]+arr[i][j];
                }
                else if(j<dp[i-1].length){
                    dp[i][j]=dp[i-1][j]+arr[i][j];
                }
            }
        }
        for(int i=0; i<n; i++){
            ret = Math.max(ret,dp[n-1][i]);
        }

        System.out.println(ret);
    }
}
