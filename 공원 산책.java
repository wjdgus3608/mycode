import java.util.*;
class Solution {
    int N,M;
    int curY=-1, curX=-1;
    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(park[i].charAt(j)=='S')
                {
                    curY = i;
                    curX = j;
                    break;
                }
            }
            if(curY!=-1 && curX!=-1) break;
        }
        
        for(int i=0; i<routes.length; i++){
            move(park,routes[i]);
        }
        
        int[] answer = {curY,curX};
        return answer;
    }
    
    private void move(String[] park, String route){
        String[] parsed = route.split(" ");
        String dir = parsed[0];
        int value = Integer.parseInt(parsed[1]);
        int temp = -1;
        boolean flag = true;
        switch(dir){
            case "E":
                if(curX+value>=M) break;
                flag = true;
                for(int i=1; i<=value; i++){
                    if(park[curY].charAt(curX+i)=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    curX += value;
                }
                break;
            case "W":
                if(curX-value<0) break;
                flag = true;
                for(int i=1; i<=value; i++){
                    if(park[curY].charAt(curX-i)=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    curX -= value;
                }
                break;
            case "S":
                if(curY+value>=N) break;
                flag = true;
                for(int i=1; i<=value; i++){
                    if(park[curY+i].charAt(curX)=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    curY += value;
                }
                break;
            case "N":
                if(curY-value<0) break;
                flag = true;
                for(int i=1; i<=value; i++){
                    if(park[curY-i].charAt(curX)=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    curY -= value;
                }
                break;
        }
    }
}
