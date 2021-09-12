
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int N,M,T;
	static long ret;
	
	public static void comb(int N, int M) {
		N = Math.min(N, M-N);
		long num1 = 1;
		for(int i=M; i>M-N; i--) {
			num1*=i;
		}
		
		long num2 = 1;
		for(int i=1; i<=N; i++) {
			num2*=i;
		}
		
		ret = num1/num2;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			comb(N,M);
			
			sb.append(ret+"\n");
			ret = 0;
		}
		
		System.out.print(sb);
		
	}
	
}



