
import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int per;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        int[][]arr = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE);
            arr[i][i]=0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            arr[start][end]=1;
            arr[end][start]=1;
        }

        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][k]==Integer.MAX_VALUE || arr[k][j]==Integer.MAX_VALUE) continue;
                    arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=0; j<N; j++){
//                System.out.print(arr[i][j]+" ");
                sum+=arr[i][j];
            }
//            System.out.println();
            if(ret>=sum){
                if(ret==sum){
                    per = Math.min(per,i+1);
                    continue;
                }
                per = i+1;
                ret = sum;
            }
        }

        System.out.println(per);
    }
}
