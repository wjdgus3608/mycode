

import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static int ret;

    public static int lowerBound(int num, int left, int right){
        int l = left;
        int r = right;
        while(l<r){
            int mid = (l+r)/2;
            if(dp[mid]<num){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        int len=0;
        dp = new int[N];
        Arrays.fill(dp,-1);
        for(int i=0; i<N; i++){
            int num = arr[i];
            if(len==0 || dp[len-1]<num){
                dp[len]=num;
                len++;
            }
            else{
                int index = lowerBound(num,0,len-1);
                dp[index]=num;
            }
        }

        ret = len;

        bw.write(Integer.toString(N-ret)+"\n");



        br.close();
        bw.flush();
        bw.close();

    }





}




