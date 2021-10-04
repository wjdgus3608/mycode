import java.util.*;
class Solution {
    ArrayList<Node>[] list;
    int[] dist;
    boolean[] visit;
    public void diik(int start,int N, int K){
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.dis,b.dis);
        });
        q.add(new Node(start,0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(visit[cur.end]) continue;
            visit[cur.end]=true;
            for(Node node: list[cur.end]){
                if(dist[cur.end]==Integer.MAX_VALUE) continue;
                if(dist[node.end]>dist[cur.end]+node.dis){
                    dist[node.end]=dist[cur.end]+node.dis;
                    q.add(new Node(node.end,dist[node.end]));
                }
            }
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        //그래프 초기화
        int n=road.length;
        dist = new int[N+1];
        list = new ArrayList[N+1];
        visit = new boolean[N+1];
        for(int i=0; i<=N; i++){
            list[i]=new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            int start = road[i][0];
            int end = road[i][1];
            int dis = road[i][2];
            list[start].add(new Node(end,dis));
            list[end].add(new Node(start,dis));
        }
            
        //다익스트라
        diik(1,N,K);
        //결과 출력
        for(int i=1; i<=N; i++){
            if(dist[i]<=K) answer++;
            System.out.print(dist[i]+" ");
            
        }
        return answer;
    }
}

class Node{
    int end,dis;
 
    Node(int end, int dis){
        this.end=end;
        this.dis=dis;
    }
}
