
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N,M;
	static long ret1;
	static long ret2;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		Long[] arr = new Long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i]=Long.parseLong(st.nextToken());
		
		Arrays.sort(arr,(a,b)->Long.compare(Math.abs(a), Math.abs(b)));
		
		long min = Long.MAX_VALUE;
		for(int i=0; i<N-1; i++) {
			long sum = Math.abs(arr[i]+arr[i+1]);
			if(sum<min) {
				min = sum;
				ret1 = Math.min(arr[i], arr[i+1]);
				ret2 = Math.max(arr[i], arr[i+1]);
			}
		}
		
		bw.write(ret1+" "+ret2);
		bw.flush();
		bw.close();
		br.close();
	}
}

