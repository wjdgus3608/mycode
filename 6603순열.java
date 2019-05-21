import java.io.BufferedReader;

public class Main {
	static int k;
	static int[] S;
	static boolean[] visit;
	public static void solve(int n, int depth,int[] arr) {
		if(depth==6) {
			for(int i=0; i<6; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0; i<n; i++){
			if(!visit[i]) {
				visit[i]=true;
				arr[depth]=S[i];
				solve(n,depth+1,arr);
				visit[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			k=Integer.valueOf(st.nextToken());
			if(k==0) break;
			S=new int[k];
			visit=new boolean[k];
			for(int i=0; i<k; i++) {
				S[i]=Integer.valueOf(st.nextToken());
			}
			int[] arr=new int[k];
			solve(k,0,arr);
			System.out.println();
		}
	}
}
