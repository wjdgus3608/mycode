
import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T,N,M,K,ret;
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void bfs(Point start){
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x]=true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0; i<4; i++){
                int xx = cur.x+dx[i];
                int yy = cur.y+dy[i];
                if(xx<0 || yy<0 || xx>=M || yy>=N || visit[yy][xx]) continue;
                if(map[yy][xx]==1){
                    visit[yy][xx]=true;
                    q.add(new Point(xx,yy));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new boolean[N][M];
            Queue<Point> q = new LinkedList<>();
            for(int k=0; k<K; k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                q.add(new Point(x,y));
                map[y][x]=1;
            }
            while(!q.isEmpty()){
                Point start = q.poll();
                if(!visit[start.y][start.x]){
                    bfs(start);
                    ret++;
                }
            }

            sb.append(ret+"\n");
            ret=0;
        }

        System.out.println(sb);
    }
}

class Point{
    int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

