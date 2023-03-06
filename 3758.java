import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int T,n,k,t,m;
	static HashMap<CustomKey,Integer> map = new HashMap<>();
	static HashMap<Integer,Team> teamMap = new HashMap<>();
	static ArrayList<Team> list;
	static int ret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				CustomKey key = new CustomKey(a,b);
				
				map.put(key, Math.max(map.getOrDefault(key, 0), c));
				if(teamMap.containsKey(a)) {
					Team temp = teamMap.get(a);
					temp.submitcnt+=1;
					temp.time=j;
					teamMap.put(a, temp);
				}
				else
					teamMap.put(a, new Team(0,1,j,a));
			}
			
			for(CustomKey key:map.keySet()) {
				int teamNum = key.teamNum;
				int proNum = key.proNum;
				
				Team temp = teamMap.get(teamNum);
				temp.totalScore+=map.get(key);
				teamMap.put(teamNum, temp);
			}
			
			list = new ArrayList<Team>(teamMap.values());
			Collections.sort(list);
			
			for(int k=0; k<list.size(); k++) {
				if(list.get(k).teamNum==t) {
					sb.append((k+1)).append("\n");
				}
			}
			
			map.clear();
			teamMap.clear();
		}
		
		System.out.print(sb);
	}
}

class Team implements Comparable<Team>{
	int totalScore, submitcnt, time, teamNum;
	Team(int totalScore, int submitCnt, int time, int teamNum){
		this.totalScore=totalScore;
		this.submitcnt=submitCnt;
		this.time=time;
		this.teamNum=teamNum;
	}
	@Override
	public int compareTo(Team o) {
		if(this.totalScore==o.totalScore) {
			if(this.submitcnt==o.submitcnt)
				return this.time-o.time;
			return this.submitcnt-o.submitcnt;
		}
		return o.totalScore-this.totalScore;
	}
	
}

class CustomKey{
	int teamNum, proNum;
	CustomKey(int teamNum, int proNum){
		this.teamNum=teamNum;
		this.proNum=proNum;
	}
	
	@Override
	public int hashCode() {
		return Integer.toString(teamNum).hashCode()+Integer.toString(proNum).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		CustomKey c = (CustomKey) obj;
		return (this.teamNum==c.teamNum && this.proNum==c.proNum);
	}
	
}
