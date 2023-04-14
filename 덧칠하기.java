class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int cur=section[0];
        for(int i=1; i<section.length; i++){
            if(cur+m<=section[i]){
                cur=section[i];
                answer++;
            }
        }
        return answer;
    }
}
