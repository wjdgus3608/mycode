class Solution {
    int lux=Integer.MAX_VALUE,luy=Integer.MAX_VALUE,rdx,rdy;
    public int[] solution(String[] wallpaper) {
        int N = wallpaper.length;
        for(int i=0; i<N; i++){
            String str = wallpaper[i];
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)=='#'){
                    lux=Math.min(lux,j);
                    luy=Math.min(luy,i);
                    rdx=Math.max(rdx,j+1);
                    rdy=Math.max(rdy,i+1);
                }
            }
        }
        
        int[] answer = {luy, lux, rdy, rdx};
        
        return answer;
    }
}
