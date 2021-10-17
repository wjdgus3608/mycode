
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[100];
        Arrays.fill(map,-1);
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            map[start]=end;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            map[start]=end;
        }

        int[] dp = new int[100];
        for(int i=0; i<100; i++){
            dp[i]=Integer.MAX_VALUE;
        }

        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=1;
        dp[5]=1;
        dp[6]=1;
        for(int j=1; j<7; j++){
            if(map[j]!=-1){
                int num = map[j];
                if(num>j)
                dp[num]=1;
                else
                    dp[j]=Integer.MAX_VALUE;
            }
        }
        for(int i =7; i<100; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=6; j++){
                min=Math.min(min,dp[i-j]);
            }
            dp[i]=Math.min(dp[i],min+1);
            if(map[i]!=-1){
                int num=map[i];
                if(num>i)
                dp[num]=dp[i];
                else {
                    dp[num]=Math.min(dp[num],dp[i]);
                    dp[i]=Integer.MAX_VALUE;
                }

            }
        }

        for(int i =7; i<100; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=6; j++){
                min=Math.min(min,dp[i-j]);
            }
            dp[i]=Math.min(dp[i],min+1);
            if(map[i]!=-1){
                int num=map[i];
                if(num>i)
                    dp[num]=dp[i];
                else {
                    dp[num]=Math.min(dp[num],dp[i]);
                    dp[i]=Integer.MAX_VALUE;
                }

            }
        }



        System.out.println(dp[99]);

    }
}
