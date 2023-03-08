import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N,M;
	static ArrayList[] list;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static int[] dist;
	static boolean[] visit;
	static int start;
	public static void dik() {
		Queue<Integer> q= new LinkedList<>();
		q.add(start);
		dist[start]=0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(visit[cur]) continue;
			visit[cur]=true;
			for(int i=0; i<list[cur].size(); i++) {
				int next = (int)list[cur].get(i);
				int value = (dist[cur]==Integer.MAX_VALUE?0:dist[cur])+1;
				if(dist[next]>value) {
					dist[next]=value;
					q.add(next);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) start=i*M+j;
			}
		}
		
		list = new ArrayList[N*M];
		for(int i=0; i<N*M; i++)
			list[i]=new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<4; k++) {
					int nexty = i+dy[k];
					int nextx = j+dx[k];
					if(nexty<0 || nextx<0 || nexty>=N || nextx>=M || arr[nexty][nextx]!=1) continue;
					list[i*M+j].add(nexty*M+nextx);
				}
			}
		}
		
		dist = new int[N*M];
		visit = new boolean[N*M];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dik();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(dist[i*M+j]==Integer.MAX_VALUE)
					dist[i*M+j]=(arr[i][j]==0?0:-1);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				bw.write(Integer.toString(dist[i*M+j]));
				if(j!=M-1)
					bw.write(" ");
			}
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
