import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int cury,curx;
    int gy,gx;
    int N,M;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    char[][] map;
    boolean[][] visit;
    public int getValue(int dir, Point now){
        int cnt=0;
        int cur=0;
        switch(dir){
            case 0:
                cur=now.y;
                while(cur-1>=0 && map[cur-1][now.x]!='D'){
                    cur--;
                    cnt++;
                }
                break;
            case 1:
                cur=now.y;
                while(cur+1<N && map[cur+1][now.x]!='D'){
                    cur++;
                    cnt++;
                }
                break;
            case 2:
                cur=now.x;
                while(cur-1>=0 && map[now.y][cur-1]!='D'){
                    cur--;
                    cnt++;
                }
                break;
            case 3:
                cur=now.x;
                while(cur+1<M && map[now.y][cur+1]!='D'){
                    cur++;
                    cnt++;
                }
                break;
        }
        return cnt;
    }
    public void bfs(){
        Queue<Point> q= new LinkedList<>();
        q.add(new Point(cury,curx,0));
        visit[cury][curx]=true;
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i=0; i<4; i++){
                int value = getValue(i,now);
                int nexty = now.y+dy[i]*value;
                int nextx = now.x+dx[i]*value;
                if(visit[nexty][nextx]) continue;
                if(nexty==gy && nextx==gx){
                    answer = now.d+1;
                    return;
                }
                visit[nexty][nextx]=true;
                q.add(new Point(nexty,nextx,now.d+1));
            }
        }
    }
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        map=new char[N][M];
        int y=0;
        for(String str:board){
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)=='R'){
                    cury=y;
                    curx=j;
                }
                else if(str.charAt(j)=='G'){
                    gy=y;
                    gx=j;
                }
                map[y][j]=str.charAt(j);
            }
            y++;
        }
        if(cury==gy && curx==gx)
            return 0;
        visit = new boolean[N][M];
        bfs();
        
        
        
        
        
        return answer==Integer.MAX_VALUE?-1:answer;
    }
}

class Point{
    int y,x,d;
    Point(int y, int x, int d){
        this.y=y;
        this.x=x;
        this.d=d;
    }
}
