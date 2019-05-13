import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
	static boolean visit[];
	static int ret;
	public static void dfs(int index) {
		visit[index]=true;
		if(index!=0) ret++;
		for(int i=0; i<list.get(index).size(); i++) {
			if(!visit[list.get(index).get(i)])
			dfs(list.get(index).get(i));
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.valueOf(st.nextToken());
		st=new StringTokenizer(br.readLine());
		M=Integer.valueOf(st.nextToken());
		visit=new boolean[N];
		for(int k=0; k<N; k++) {
			ArrayList<Integer> temp=new ArrayList<>();
			list.add(temp);
		}
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int num1=Integer.valueOf(st.nextToken());
			int num2=Integer.valueOf(st.nextToken());
			list.get(num1-1).add(num2-1);
			list.get(num2-1).add(num1-1);
		}
		dfs(0);
		System.out.println(ret);
	}
}
