
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;



public class Main {
	static int N,M,ret;
	static boolean[] visit;
	public static void dfs(int cnt, int[] arr, int sum, int start) {
		if(sum>M) return;
		if(cnt==3) {
			ret = Math.max(sum, ret);
			return;
		}
		
		
		for(int i=start; i<N; i++) {
			if(visit[i]) continue;
			visit[i]=true;
			dfs(cnt+1,arr,sum+arr[i],i+1);
			visit[i]=false;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		visit = new boolean[N];
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i]=num;
		}
		
		dfs(0,arr,0,0);
		System.out.println(ret);
		br.close();
	}
	
}






