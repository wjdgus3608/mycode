
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int K,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		long[] arr = new long[K];
		long max = 0;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		long start=1, end = max;
		long mid = 0;
		long ret = 0;
		while(start<=end) {
			mid = (start+end)/2;
			int cnt = 0;
			for(long len:arr) {
				cnt+=len/mid;
			}
			if(cnt>=N) {

				ret = mid;
				start = mid+1;
			}
			else {

				end = mid-1;
			}

		}
		System.out.println(ret);
	}
	
}



