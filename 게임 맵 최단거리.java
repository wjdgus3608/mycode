import java.util.*;
class Solution {
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    int ret=Integer.MAX_VALUE,N,M;
    int[][] map;
    boolean[][] visit;
    public void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1));
        visit[0][0]=true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0; i<4; i++){
                int yy = cur.y+dy[i];
                int xx = cur.x+dx[i];
                if(yy<0 || xx<0 || yy>=N || xx>=M || visit[yy][xx]) continue;
                if(yy==N-1 && xx==M-1){
                    ret = cur.cnt+1;
                    return;
                } 
                if(map[yy][xx]==1){
                    visit[yy][xx]=true;
                    q.add(new Point(yy,xx,cur.cnt+1));
                }
            }
        }
    }
    public int solution(int[][] maps) {
        map = maps;
        N = map.length;
        M = map[0].length;
        visit = new boolean[N][M];
        bfs();
        if(ret==Integer.MAX_VALUE) ret = -1;
        return ret;
    }
}

class Point{
    int y,x,cnt;
    Point(int y, int x, int cnt){
        this.y=y;
        this.x=x;
        this.cnt=cnt;
    }
}
