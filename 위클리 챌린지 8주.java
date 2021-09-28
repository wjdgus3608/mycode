
class Solution {
    public int solution(int[][] sizes) {
        int N = sizes.length;
        int max =  0;
        int minmax = 0;
        for(int i=0; i<N; i++){
            int first = sizes[i][0];
            int sec = sizes[i][1];
            max = Math.max(max,Math.max(first,sec));
            minmax = Math.max(minmax,Math.min(first,sec));
        }
        
        return max*minmax;
    }
}
