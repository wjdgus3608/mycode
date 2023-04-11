import java.util.*;
class Solution {
    int ret;
    int N,M;
    int[] dp;
    HashMap<String,Integer> map = new HashMap<>();
    public int getValue(int type,String name){
        int target = map.get(name);
        if(type<=target) return 1;
        return (int)Math.pow(5,type-target);
    }
    public void dfs(int depth, int sum, int[] picks, String[] minerals){
        // if(dp[depth]<sum) return;
        if(depth==M){
            dp[depth]=Math.min(dp[depth],sum);
            return;
        }
        dp[depth]=Math.min(dp[depth],sum);
        for(int i=0; i<3; i++){
            if(picks[i]<=0) continue;
            picks[i]--;
            int remain=5;
            int next = 0;
            int value=0;
            while(depth+next<M && remain>0){
                value+=getValue(i,minerals[depth+next]);
                next++;
                remain--;
            }
            dfs(depth+next,sum+value,picks,minerals);
            picks[i]++;
        }
        // dp[depth]=Math.min(dp[depth],sum);
    }
    
    public int solution(int[] picks, String[] minerals){
        int cnt=0;
        for(int num:picks)
            cnt+=num;
        N = cnt;
        M = minerals.length;
        dp = new int[Math.min(N*5,M)+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        map.put("diamond",0);
        map.put("iron",1);
        map.put("stone",2);
        
        dfs(0,0,picks,minerals);
        ret = dp[Math.min(N*5,M)];
        
        return ret;
    }
}
