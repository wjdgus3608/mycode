import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	static int N,M;
	static int[] arr;
	static int ret;
	
	public static void search() {
		int l = 0;
		int r = 1000000000;
		int mid = (l+r)/2;
		int result=-1;
		while(l<=r) {
			mid = (l+r)/2;
			if(cal(mid)<=M) {
				l = mid+1;
				result=mid;
			}
			else {
				r = mid-1;
			}
		}
		ret = result;
	}
	
	public static long cal(int mid) {
		long sum=0;
		for(int i=0; i<N; i++) {
			if(arr[i]>mid) sum+=mid;
			else sum+=arr[i];
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb =new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		long sum=0;
		int max=0;
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum+=arr[i];
			max = Math.max(max, arr[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		
		if(sum<=M) {
			System.out.println(max);
			return;
		}
		
		search();
		
		
		System.out.print(ret);
		
	}
}
