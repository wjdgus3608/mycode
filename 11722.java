import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            A[i]=Integer.parseInt(st.nextToken());

        int len = 1;
        int[] dp = new int[N];
        Arrays.fill(dp,-1);
        dp[0]=A[0];
        for(int i=1; i<N; i++){
            if(dp[len-1]>A[i]){
                dp[len++]=A[i];
            }
            else{
                int index = getLowerBound(dp,A[i],0,len);
                dp[index]=A[i];
            }
        }
        bw.write(Integer.toString(len));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int getLowerBound(int[] dp, int target, int left, int right){
        int l = left;
        int r = right;
        while(l<r){
            int mid = (l+r)/2;
            if(dp[mid]>target){
                l = mid+1;
            }
            else{
                r=mid;
            }
        }
        return r;
    }
}
