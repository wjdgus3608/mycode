
import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T,N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T=Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++){
            Queue<Point> q = new LinkedList<>();
            PriorityQueue<Point> pq = new PriorityQueue<>((a,b)-> -Integer.compare(a.imp,b.imp));
            st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                int imp = Integer.parseInt(st.nextToken());
                pq.add(new Point(i, imp));
                q.add(new Point(i,imp));
            }
            int ret = 0;
            while(!pq.isEmpty() && !q.isEmpty()){
                Point cur = pq.peek();
                Point rcur = q.poll();
                while(cur.imp != rcur.imp){
                    q.add(rcur);
                    rcur=q.poll();
                }
                pq.poll();
                if(rcur.id==M){
                    sb.append(ret+1+"\n");
                    break;
                }
                ret++;
            }
        }

        System.out.print(sb);

    }
}

class Point{
    int id,imp;
    Point(int id, int imp){
        this.id=id;
        this.imp=imp;
    }
}

