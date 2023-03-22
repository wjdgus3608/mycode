import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

	static int N,S;
	static int[] arr;
	static int ret=Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		if(S==0) {
			System.out.println(1);
			return;
		}
		int d=0;
		int sum=0;
		int index=0;
		while(index<N && sum<S) {
			sum+=arr[index++];
			d++;
		}
		while(sum-arr[index-d]>=S) {
			sum-=arr[index-d];
			d--;
		}
		if(sum>=S)
			ret = d;
		int i = index;
		while(true){
			
			if(sum-arr[i-d]>=S) {
				sum-=arr[i-d];
				d--;
				ret=Math.min(ret, d);
				continue;
			}
			else {
				if(i==N) break;
				sum-=arr[i-d];
				sum+=arr[i];
				i++;
			}
		}
		
	
		bw.write(Integer.toString(ret==Integer.MAX_VALUE?0:ret));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
