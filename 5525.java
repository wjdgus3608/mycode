
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,M,ret;
	static String S;
	public static int[] getPi(String S) {
		int N = S.length();
		int[] pi = new int[N];
		int j=0;
		for(int i=1; i<N; i++) {
			while(j>0 && S.charAt(i)!=S.charAt(j)) {
				j=pi[j-1];
			}
			if(S.charAt(i)==S.charAt(j)) {
				pi[i]=++j;
			}
		}
		return pi;
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++)
			sb.append("IO");
		sb.append("I");
		String P = sb.toString();
		int[] pi = getPi(P);
		int j=0;
		for(int i=0; i<M; i++) {
			while(j>0 && S.charAt(i)!=P.charAt(j)) {
				j=pi[j-1];
			}
			if(S.charAt(i)==P.charAt(j)) {
				if(j==P.length()-1) {
					ret++;
					j=pi[j];
				}
				else {
					j++;
				}
			}
		}
		
		
		System.out.println(ret);
	}

}
