
import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,ret1,ret2,ret3,ret4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long sum = 0;
        long[] arr = new long[N];
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            sum+=num;
            ret1 = Math.round(sum/(float)N);
            arr[i]=num;
            map.put(num,map.getOrDefault(num,0)+1);
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        Arrays.sort(arr);

        ret2=(int)arr[N/2];
        int topCnt=0, topKey=0;
        boolean flag = false;
        for(int key:map.keySet()){
            if(topCnt<map.get(key)){
                topCnt = map.get(key);
                topKey = key;
                flag =true;
            }
            else if(topCnt==map.get(key) && flag){
                topKey=key;
                flag=false;
            }
        }
        ret3=topKey;

        ret4=max-min;
        System.out.println(ret1);
        System.out.println(ret2);
        System.out.println(ret3);
        System.out.println(ret4);
    }
}


