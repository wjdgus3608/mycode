import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int T;
    static int N,W,H;
    static int ret=Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Point> list=new ArrayList<>();
    public static void dfs(int cnt) {
        if(cnt==N) {
            int count=0;
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    if(map[i][j]!=0) count++;
                }
            }
             
            ret=Math.min(ret,count);
            return;
        }
        int[][] temp=new int[H][W];
        for(int x=0; x<W; x++) {
            backup(map,temp);
            crush(x);
            dfs(cnt+1);
            backup(temp,map);
        }
         
    }
    public static void crush(int index) {
        int i;
        boolean check=false;
        for(i=0; i<H; i++) {
            if(map[i][index]!=0) {
                check=true;
                break;
            }
        }
        if(check) {
            bfs(new Point(i,index));
        }
    }
    public static void bfs(Point start) {
        remove(start);
        if(map[start.y][start.x]==1) {
            do_remove();
            return;
        }
        boolean[][] visit=new boolean[H][W];
        int[] dy= {-1,1,0,0};
        int[] dx= {0,0,-1,1};
        Queue<Point> q=new LinkedList<>();
        q.add(start);
        visit[start.y][start.x]=true;
        while(!q.isEmpty()) {
            Point cur=q.poll();
            for(int i=0; i<4; i++) {
                int nexty=cur.y;
                int nextx=cur.x;
                for(int j=0; j<map[cur.y][cur.x]-1; j++) {
                    nexty+=dy[i];
                    nextx+=dx[i];
                    if(nexty<0 || nextx<0 || nexty>=H || nextx>=W || visit[nexty][nextx]) continue;
                    if(map[nexty][nextx]!=0) {
                        remove(new Point(nexty,nextx));
                        if(map[nexty][nextx]!=1) {
                            visit[nexty][nextx]=true;
                            q.add(new Point(nexty,nextx));
                        }
                    }
                }
            }
        }
        do_remove();
    }
    public static void remove(Point target) {
        boolean check=true;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).y==target.y && list.get(i).x==target.x) {
                check=false;
                break;
            }
        }
        if(check)
        list.add(target);
    }
    public static void do_remove() {
        Collections.sort(list,(p1,p2)->{
            return Integer.compare(p1.y, p2.y);
        });
        for(int i=0; i<list.size(); i++) {
            Point temp=list.get(i);
            int nexty=temp.y;
            while(nexty>0) {
                map[nexty][temp.x]=map[nexty-1][temp.x];
                nexty--;
            }
            map[nexty][temp.x]=0;
        }
        list.clear();
    }
    public static void backup(int[][] real,int[][] copy) {
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++)
                copy[i][j]=real[i][j];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        T=Integer.valueOf(st.nextToken());
        for(int k=0; k<T; k++) {
            st=new StringTokenizer(br.readLine()," ");
            N=Integer.valueOf(st.nextToken());
            W=Integer.valueOf(st.nextToken());
            H=Integer.valueOf(st.nextToken());
            map=new int[H][W];
            for(int i=0; i<H; i++) {
                st=new StringTokenizer(br.readLine()," ");
                for(int j=0; j<W; j++) {
                    map[i][j]=Integer.valueOf(st.nextToken());
                }
            }
            dfs(0);
            System.out.print("#"+(k+1)+" ");
            System.out.println(ret);
            ret=Integer.MAX_VALUE;
        }
    }
}
 
class Point{
    int y,x;
    Point(int y,int x){
        this.y=y;
        this.x=x;
    }
}
