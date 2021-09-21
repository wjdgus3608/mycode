
import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,r,c,N,ret;
    static int[] dy = {0,0,1,1};
    static int[] dx = {0,1,0,1};
    static boolean isEnd;
    public static void solve(Point start, int size){
        if(isEnd) return;
        if(size==2){
            for(int i=0; i<4; i++){
                int xx = start.x+dx[i];
                int yy = start.y+dy[i];
                ret++;
                if(yy==r && xx==c){
                    isEnd = true;
                    return;
                }
            }
            return;
        }
        int val = size/2;
        int yy = start.y+val;
        int xx = start.x+val;
        if(yy>r && xx>c)
        solve(start,val);
        if(yy>r && xx<=c) {
            ret+=val*val;
            solve(new Point(start.y, start.x + val), val);
        }
        if(xx>c && yy<=r) {
            ret+=(val*val)*2;
            solve(new Point(start.y + val, start.x), val);
        }
        if(yy<=r && xx<=c) {
            ret+=(val*val)*3;
            solve(new Point(start.y + val, start.x + val), val);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        N=(int)Math.pow(2,n);
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        solve(new Point(0,0),N);

        System.out.println(ret-1);
    }
}

class Point{
    int x,y;
    Point(int y, int x){
        this.y=y;
        this.x=x;
    }
}
