
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[M+1];
        Arrays.fill(arr,true);
        arr[0]=false;
        arr[1]=false;
        int num=2;
        while(num<=M){
            long sum = 1;
            long cnt = 2;
            while(sum<=M){
                arr[(int)sum]=false;
                sum=num*cnt++;
            }
            num++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=N; i<=M; i++){
            if(arr[i]) sb.append(i+"\n");
        }

        System.out.print(sb);

    }
}

