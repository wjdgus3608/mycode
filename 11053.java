import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
	static int N,ret=1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			int num = Integer.parseInt(st.nextToken());
			arr[i]=num;
		}
		
		int[] dp = new int[N];
		
		Arrays.fill(dp, 1);
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
					ret=Math.max(ret, dp[i]);
				}
			}
		}
		
		System.out.println(ret);
		br.close();
	}
	
}





