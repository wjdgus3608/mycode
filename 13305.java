import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static long ret;
	static int N;
	static long[] W;
	static long[] D;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = new long[N];
		D = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			D[i+1]=Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			W[i]=Long.parseLong(st.nextToken());
		}
		
		long gas = 0;
		for(int i=0; i<N; i++) {
			int index = findCity(i);
			if(index!=-1) {
				long dis = getDistance(i,index);
				ret+=chargeGas(i,dis);
				i=index-1;
			}
			else {
				ret+=(getDistance(i,N-1)*W[i]);
				break;
			}
		}
		
		System.out.println(ret);
	}
	
	public static int findCity(int start) {
		for(int i=start+1; i<N; i++) {
			if(W[i]<W[start]) return i;
		}
		return -1;
	}
	
	public static long getDistance(int start, int end) {
		long sum=0;
		for(int i=start+1; i<=end; i++) {
			sum+=D[i];
		}
		return sum;
	}
	
	public static long chargeGas(int at, long dis) {
		return W[at]*dis;
	}
}
