import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	static int N,M;
	static int[] arr;
	
	public static void use(int gen, int num) {
		if(gen==1) {
			int idx=num-1;
			int mul=2;
			while(idx<N) {
				arr[idx]=(arr[idx]==1?0:1);
				idx=mul*num-1;
				mul++;
			}
		}
		else {
			int l=num-1;
			int r=num-1;
			int left = l;
			int right = r;
			while(true) {
				l--;
				r++;
				if(l<0 || r>=N) break;
				if(arr[l]!=arr[r]) break;
				left=l;
				right=r;
			}
			for(int i=left; i<=right; i++) {
				arr[i]=(arr[i]==1?0:1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i]=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			use(gen,num);
		}
		for(int i=0; i<N; i++) {
			sb.append(arr[i]);
			if((i+1)%20==0 && i!=N-1)
				sb.append("\n");
			else if((i+1)%20!=0)
				sb.append(" ");
			
		}
		System.out.print(sb);
		
	}
}
