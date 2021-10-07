import java.util.ArrayList;

class Solution {
    boolean[] visit;
    public int check(int del_start, int del_end, ArrayList<Integer>[] map, int start, int cnt){
        for(int i=0; i<map[start].size(); i++){
            int next = map[start].get(i);
            if(visit[next] || (start==del_start && next==del_end) ||
              (start==del_end && next==del_start)) continue;
            visit[next]=true;
            cnt=check(del_start,del_end,map,next,cnt+1);
        }
        return cnt;
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        //그래프 만들기
        ArrayList<Integer>[] map = new ArrayList[n+1];
        
        for(int i=1; i<n+1; i++){
            map[i]=new ArrayList<>();
        }
        for(int i=0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            
            map[start].add(end);
            map[end].add(start);
        }
        
        //끊을곳 한곳 선택
        for(int i=0; i<wires.length; i++){
            int del_start = wires[i][0];    
            int del_end = wires[i][1];
            int[] cnts = new int[2];
            int index=0;
            visit = new boolean[n+1];
            for(int j=1; j<=n; j++){
                if(visit[j]) continue;
                visit[j]=true;
                cnts[index++]=check(del_start,del_end,map,j,1);
            }
            answer = Math.min(answer,Math.abs(cnts[0]-cnts[1]));
        }
        //그룹 체크
        return answer;
    }
}
