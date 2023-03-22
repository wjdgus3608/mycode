import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N,C;
	static int[] arr;
	static int ret;
	
	public static boolean check(int num) {
		int diff=0;
		int cnt=0;
		for(int i=1; i<N; i++) {
			diff+=(arr[i]-arr[i-1]);
			if(diff>=num) {
				diff=0;
				cnt++;
			}
		}
		if(cnt+1>=C) return true;
		return false;
	}
	
	public static void bin() {
		int l=1;
		int r=arr[N-1]-arr[0];
		int mid=(l+r)/2;
		while(l<=r) {
			if(check(mid)) {
				ret=Math.max(ret, mid);
				l=mid+1;
			}
			else {
				r=mid-1;
			}
			mid=(l+r)/2;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		bin();
	
		bw.write(Integer.toString(ret));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
