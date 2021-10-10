import java.util.HashMap;
class Solution {
    int l_x=0, l_y=3, r_x=2, r_y=3;
    Point[] map;
    public void move(String hand, int num){

        Point cur = map[num];
        if(hand.equals("L")){
            l_x=cur.x;
            l_y=cur.y;
        }
        else{
            r_x=cur.x;
            r_y=cur.y;
        }

    }

    public String checkDistance(int num, String hand){
        Point cur = map[num];

        int dis1 = Math.abs(cur.y-l_y)+Math.abs(cur.x-l_x);
        int dis2 = Math.abs(cur.y-r_y)+Math.abs(cur.x-r_x);
        if(dis1<dis2){
            return "L";
        }
        else if(dis1>dis2){
            return "R";
        }
        return hand.equals("left")?"L":"R";
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        map = new Point[10];
        map[0] = new Point(3,1);
        int index=1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                map[index++]=new Point(i,j);
        }

        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            if(num==1 || num==4 || num==7){
                sb.append("L");
                move("L",num);
            }
            else if(num==3 || num==6 || num==9){
                sb.append("R");
                move("R",num);
            }
            else{
                String nowhand = checkDistance(num,hand);
                sb.append(nowhand);
                move(nowhand,num);
            }
        }

        return sb.toString();
    }
}

class Point{
    int x,y;
    Point(int y, int x){
        this.y=y;
        this.x=x;
    }
}
