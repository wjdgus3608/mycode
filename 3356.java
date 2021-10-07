
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int L,ret;
	static String str;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		int[] pi = new int[L];
		int j=0;
		for(int i=1; i<str.length(); i++) {
			while(j>0 && str.charAt(i)!=str.charAt(j)) {
				j=pi[j-1];
			}
			if(str.charAt(i)==str.charAt(j)) {
				pi[i]=++j;
			}
		}
		
		System.out.println(L-pi[L-1]);
		
	}
	
}




