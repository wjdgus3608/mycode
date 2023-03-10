import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N,D;
	static ArrayList<Road> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			if(end<=D)
				list.add(new Road(start,end,dis));
		}
		
		int[] dp = new int[D+1];
		for(int i=1; i<D+1; i++)
			dp[i]=i;
		
		for(int i=0; i<D+1; i++) {
			if(i!=0)
				dp[i]=Math.min(dp[i], dp[i-1]+1);
			for(int j=0; j<list.size(); j++) {
				if(list.get(j).start==i) {
					Road r = list.get(j);
					dp[r.end]=Math.min(dp[r.end], dp[i]+r.dis);
				}
			}
		}
		
		bw.write(Integer.toString(dp[D]));
		bw.flush();
		bw.close();
		br.close();
	}
}

class Road{
	int start, end, dis;
	Road(int start, int end, int dis){
		this.start=start;
		this.end=end;
		this.dis=dis;
	}
}
