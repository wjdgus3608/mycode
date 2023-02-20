import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static String S;
	static int ret = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = st.nextToken();
		
		String[] P = S.split("\\-");
		
		if(P.length==1) {
			int sum = 0;
			P = S.split("\\+");
			for(String str:P) {
				sum+=Integer.parseInt(str);
			}
			System.out.print(sum);
			return;
		}
		
		String[] temp = P[0].split("\\+");
		int sum=0;
		for(String str:temp) {
			sum+=Integer.parseInt(str);
		}
		
		for(int i=1; i<P.length; i++) {
			temp = P[i].split("\\+");
			for(String str:temp) {
				sum-=Integer.parseInt(str);
			}
		}
		
		System.out.println(sum);
	}
}
