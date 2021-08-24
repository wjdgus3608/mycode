import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int N,K;
	static long ret;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[1000001];
		int max = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int size = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			arr[index] = size;
			max = Math.max(max, index);
		}
		
		long sum = 0;
		int d = K*2+1;
		
		for(int i=0; i<=max; i++) {
			if(i>=d)
			sum-=arr[i-d];
			sum+=arr[i];
			ret = Math.max(ret, sum);
		}
		
		System.out.println(ret);
	}

}
