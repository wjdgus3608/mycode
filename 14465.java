import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[N];
		
		for(int k=0; k<B; k++) {
			int index = Integer.parseInt(br.readLine())-1;
			arr[index] = true;
		}
		
		int cnt = 0;
		
		for(int i=0; i<K; i++) {
			if(arr[i])
				cnt++;
		}
		
		int ret = cnt;
		
		for(int i=0; i<N-K; i++) {
			if(arr[i])
				cnt--;
			if(arr[i+K])
				cnt++;
			ret = Math.min(ret, cnt);
		}
		
		System.out.println(ret);
		
	}

}
