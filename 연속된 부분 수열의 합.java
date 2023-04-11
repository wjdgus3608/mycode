import java.util.*;
class Solution {
    int N;
    public int[] solution(int[] sequence, int k) {
        N = sequence.length;
        
        int start=0, end=0;
        int retStart=0, retEnd=0;
        int d=1;
        int saveD=Integer.MAX_VALUE;
        int sum=sequence[0];
        while(start<N){
            if(sum<k){
                if(end+1>=N) break;
                sum+=sequence[++end];
                d++;
            }
            else{
                if(sum==k){
                    if(saveD>d){
                        retStart = start;
                        retEnd = end;
                        saveD=d;
                    }
                }
                sum-=sequence[start++];
                d--;
            }
        }
        
        
        int[] answer = {retStart,retEnd};
        
        return answer;
    }
}
