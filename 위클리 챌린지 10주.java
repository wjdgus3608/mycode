import java.util.*;
class Solution {
    HashSet<Point> set = new HashSet<>();
    public String[] solution(int[][] line) {
        
        int N = line.length;
        //모든 교점 구하기
        for(int i=0; i<N-1; i++){
            int[] line1 = line[i];
            for(int j=i+1; j<N; j++){
                int[] line2 = line[j];
                long A = line1[0];
                long B = line1[1];
                long E = line1[2];
                long C = line2[0];
                long D = line2[1];
                long F = line2[2];
                if((A*D-B*C)==0) continue;
                if((B*F-E*D)%(A*D-B*C)!=0 || (E*C-A*F)%(A*D-B*C)!=0) continue;
                long x = (B*F-E*D) / (A*D-B*C);
                long y = (E*C-A*F) / (A*D-B*C);
                set.add(new Point((int)y,(int)x));
            }
        }
        //교점 범위 구하기
        int X=Integer.MAX_VALUE,Y=Integer.MAX_VALUE;
        int XX=Integer.MIN_VALUE,YY=Integer.MIN_VALUE;
        for(Point cur:set){
            X=Math.min(X,cur.x);
            Y=Math.min(Y,cur.y);
            XX=Math.max(XX,cur.x);
            YY=Math.max(YY,cur.y);
        }
        //교점 좌표 변경
        int dy = -Y;
        int dx = -X;
        Queue<Point> q = new LinkedList<>();
        for(Point cur:set){
            Point next = new Point(cur.y+dy,cur.x+dx);
            q.add(next);
        }
        //그리기
        char[][] arr = new char[YY-Y+1][XX-X+1];
        for(int i=0; i<YY-Y+1; i++){
            for(int j=0; j<XX-X+1; j++)
                arr[i][j]='.';
        }
            
        while(!q.isEmpty()){
            Point cur = q.poll();
            arr[cur.y][cur.x]='*';
        }
        String[] answer = new String[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<XX-X+1; j++){
                sb.append(arr[i][j]);
            }
            answer[arr.length-1-i]=sb.toString();
        }
        return answer;
    }
}

class Point{
    int x,y;
    Point(int y, int x){
        this.y=y;
        this.x=x;
    }
    
    @Override
    public boolean equals(Object target){
        Point temp = (Point) target;
        if(this.y==temp.y && this.x==temp.x) return true;
        return false;
    }
    
    @Override
    public int hashCode(){
        return Integer.hashCode(this.y)+Integer.hashCode(this.x);
    }
}
