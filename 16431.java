
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int by,bx,dy,dx,jy,jx;
    static int[] bdy = {-1,1,0,0,-1,-1,1,1};
    static int[] bdx = {0,0,-1,1,-1,1,-1,1};
    static int[] ddy = {-1,1,0,0};
    static int[] ddx = {0,0,-1,1};
    static int bret=Integer.MAX_VALUE, dret=Integer.MAX_VALUE;
    static boolean[][] visit;
    public static void bfs1(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(by,bx,0));
        visit[by][bx]=true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0; i<8; i++){
                int yy=cur.y+bdy[i];
                int xx=cur.x+bdx[i];
                if(yy<0 || xx<0 || yy>=1000 || xx>=1000 || visit[yy][xx]) continue;
                if(yy==jy && xx==jx){
                    bret = cur.cnt+1;
                    return;
                }
                visit[yy][xx]=true;
                q.add(new Point(yy,xx, cur.cnt+1));
            }
        }
    }

    public static void bfs2(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(dy,dx,0));
        visit[dy][dx]=true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0; i<4; i++){
                int yy=cur.y+ddy[i];
                int xx=cur.x+ddx[i];
                if(yy<0 || xx<0 || yy>=1000 || xx>=1000 || visit[yy][xx]) continue;
                if(yy==jy && xx==jx){
                    dret = cur.cnt+1;
                    return;
                }
                visit[yy][xx]=true;
                q.add(new Point(yy,xx, cur.cnt+1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        by = Integer.parseInt(st.nextToken());
        bx = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        dy = Integer.parseInt(st.nextToken());
        dx = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        jy = Integer.parseInt(st.nextToken());
        jx = Integer.parseInt(st.nextToken());
        visit = new boolean[1000][1000];
        bfs1();
        visit = new boolean[1000][1000];
        bfs2();
        String ret = "";
        if(bret>dret){
            ret="daisy";
        }
        else if(dret>bret){
            ret="bessie";
        }
        else{
            ret="tie";
        }
        System.out.println(ret);
    }
}

class Point{
    int x,y,cnt;
    Point(int y, int x, int cnt){
        this.y=y;
        this.x=x;
        this.cnt=cnt;
    }
}
