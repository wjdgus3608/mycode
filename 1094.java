import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int X,ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());

        PriorityQueue<Float> q = new PriorityQueue<>();
        q.add(64f);
        int sum = 64;
        while(sum>X){
            float num = q.poll()/2.0f;
            if(sum-num>=X){
                sum-=num;
                q.add(num);
            }
            else{
                q.add(num);
                q.add(num);
            }
        }
        ret = q.size();
        System.out.println(ret);
    }
}


