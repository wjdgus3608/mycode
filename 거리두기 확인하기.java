import java.util.*;
class Solution {
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    public boolean bfs(String[] places){
        char[][] map = new char[5][5];
        Queue<Point> q =new LinkedList<>();
        ArrayList<Point> list = new ArrayList<>();
        for(int i=0; i<5; i++){
            String str = places[i];
            for(int j=0; j<5; j++){
                char c = str.charAt(j);
                map[i][j]=c;
                if(c=='P') list.add(new Point(i,j,0));
            }
        }
        for(Point p:list){
            q.add(p);
             while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0; i<4; i++){
                int yy = cur.y+dy[i];
                int xx = cur.x+dx[i];
                if(yy<0 || xx <0 || yy>=5 || xx>=5) continue;
                if(map[yy][xx]=='P' && cur.cnt+1<=2 && (p.y!=yy||p.x!=xx)){
                    return false;
                }
                if(map[yy][xx]!='X' && cur.cnt<2){
                    q.add(new Point(yy,xx,cur.cnt+1));
                }
                
            }
        }
        }
       
        return true;
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0; i<places.length; i++){
            answer[i]=bfs(places[i])?1:0;
            System.out.println();
        }
        return answer;
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
