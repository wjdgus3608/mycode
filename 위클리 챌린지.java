import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int N = weights.length;
        ArrayList<Boxer> ret = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            String str = head2head[i];
            int total=0;
            int winCnt=0;
            int winBigger=0;
            for(int j=0; j<N; j++){
                char c = str.charAt(j);
                if(c=='W'){
                    winCnt++;
                    if(weights[j]>weights[i]){
                        winBigger++;
                    }
                    total++;
                }
                else if(c=='L'){
                    total++;
                }
            }
            float rate = (total==0 ? 0 : winCnt/(float)total);
            ret.add(new Boxer(rate,winBigger,weights[i],i));
        }
        
        
        Collections.sort(ret,(b1,b2)->{
            if(b1.winRate==b2.winRate){
                if(b1.winBiggerCnt==b2.winBiggerCnt){
                    if(b1.weight==b2.weight){
                        return Integer.compare(b1.number,b2.number);
                    }
                    return -Integer.compare(b1.weight,b2.weight);
                }
                return -Integer.compare(b1.winBiggerCnt,b2.winBiggerCnt);
            }
           return -Float.compare(b1.winRate,b2.winRate); 
        });
        
        int[] answer = new int[N];
        for(int i=0; i<ret.size(); i++){
            Boxer bo = ret.get(i);
            answer[i] = bo.number+1;
        }
        return answer;
    }
}

class Boxer{
    float winRate;
    int winBiggerCnt;
    int weight;
    int number;
    
    Boxer(float winRate, int winBiggerCnt, int weight, int number){
        this.winRate = winRate;
        this.winBiggerCnt = winBiggerCnt;
        this.weight = weight;
        this.number = number;
    }
}
