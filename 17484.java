

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  static int N,M;
  static int[][] arr;
  static int ret=Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N=Integer.parseInt(st.nextToken());
    M=Integer.parseInt(st.nextToken());

    arr = new int[N][M];

    int[][][] dp = new int[N][M][3];
    for(int i=0; i<N; i++)
      for(int j=0; j<M; j++)
        Arrays.fill(dp[i][j],Integer.MAX_VALUE);

    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++){
        arr[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    for(int j=0; j<M; j++){
      for (int k=0; k<3; k++){
        dp[0][j][k]=arr[0][j];
      }
    }


    for(int i=1; i<N; i++){
        for(int j=0; j<M; j++){
            if(j>0)
              dp[i][j][0]=Math.min(dp[i-1][j-1][1],dp[i-1][j-1][2])+arr[i][j];
            if(j<M-1)
              dp[i][j][2]=Math.min(dp[i-1][j+1][0],dp[i-1][j+1][1])+arr[i][j];
            dp[i][j][1]=Math.min(dp[i-1][j][0],dp[i-1][j][2])+arr[i][j];
        }
    }


    for(int j=0; j<M; j++)
      for(int k=0; k<3; k++)
        ret = Math.min(dp[N-1][j][k],ret);
    System.out.print(ret);
  }

}
