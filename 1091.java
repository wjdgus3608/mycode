import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	static int N;
	static int[] P;
	static int[] S;
	static int ret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		P = new int[N];
		S = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			P[i]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			S[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] temp = new int[N];
		for(int i=0; i<N; i++)
			temp[i]=i;
		
		while(true) {
			if(check(temp)) break;
			trade(temp);
			ret++;
			if(same(temp)) {
				ret = -1;
				break;
			}
		}
		
		System.out.println(ret);
	
	}
	
	public static boolean check(int[] temp) {
		for(int i=0; i<N; i++) {
			if(P[temp[i]]!=i%3) return false;
		}
		return true;
	}
	
	public static boolean same(int[] temp) {
		for(int i=0; i<N; i++) {
			if(i!=temp[i]) return false;
		}
		return true;
	}
	
	public static void trade(int[] temp) {
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[S[i]]=temp[i];
		}
		
		for(int i=0; i<N; i++) {
			temp[i]=arr[i];
		}
	}
}
