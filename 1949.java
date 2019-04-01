import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int T;
    static int N,K;
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Point> list=new ArrayList<>();
    static int[] dy= {-1,1,0,0};
    static int[] dx= {0,0,-1,1};
    static int max_in=Integer.MIN_VALUE;
    static int ret;
    public static void dfs(int cnt, Point start,int cut) {
            Point cur=start;
            visit[cur.y][cur.x]=true;
            for(int j=0; j<4; j++) {
                int nexty=cur.y+dy[j];
                int nextx=cur.x+dx[j];
                if(nexty<0 || nextx<0 || nexty>=N || nextx>=N || visit[nexty][nextx]) continue;
                if(map[nexty][nextx]>=map[cur.y][cur.x] && cut!=0) {
                    int diff=map[nexty][nextx]-map[cur.y][cur.x];
                    if(diff+1<=cut)
                    {
                    map[nexty][nextx]-=(diff+1);
                    dfs(cnt,start,0);
                    map[nexty][nextx]+=(diff+1);
                    }
                }
                if(map[nexty][nextx]<map[cur.y][cur.x]) {
                    visit[nexty][nextx]=true;
                    dfs(cnt+1,new Point(nexty,nextx),cut);
                    visit[nexty][nextx]=false;
                }
            }
            max_in=Math.max(max_in,cnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        T=Integer.valueOf(st.nextToken());
        for(int i=0; i<T; i++) {
            st=new StringTokenizer(br.readLine()," ");
            N=Integer.valueOf(st.nextToken());
            K=Integer.valueOf(st.nextToken());
            map=new int[N][N];
            int max=Integer.MIN_VALUE;
            for(int a=0; a<N; a++) {
                st=new StringTokenizer(br.readLine()," ");
                for(int b=0; b<N; b++) {
                    map[a][b]=Integer.valueOf(st.nextToken());
                    max=Math.max(max, map[a][b]);
                }
            }
            for(int a=0; a<N; a++) {
                for(int b=0; b<N; b++) {
                    if(map[a][b]==max)
                        list.add(new Point(a,b));
                }
            }
            for(int a=0; a<list.size(); a++) {
                visit=new boolean[N][N];
                dfs(1,list.get(a),K);
            }
            ret=max_in;
            System.out.print("#"+(i+1)+" ");
            System.out.println(ret);
            max_in=Integer.MIN_VALUE;
            ret=0;
            list.clear();
        }
    }
}
 
class Point{
    int x,y;
    Point(int y,int x){
        this.y=y;
        this.x=x;
    }
}
