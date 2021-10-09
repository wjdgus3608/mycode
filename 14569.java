
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
	static int N,k,M,p;
	static ArrayList<Integer> ret = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int[][] subs = new int[N][51];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());

			for(int j=0; j<k; j++) {
				int index = Integer.parseInt(st.nextToken());
				subs[i][index]=1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int[][] emptys = new int[M][51];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			for(int j=0; j<p; j++) {
				int index = Integer.parseInt(st.nextToken());
				emptys[i][index]=1;
			}
		}
		
		for(int i=0; i<M; i++) {
			int[] person = emptys[i];
			int cnt = 0;
			for(int j=0; j<N; j++) {
				int[] sub = subs[j];
				boolean flag = true;
				for(int k=1; k<51; k++) {
					if((person[k]&sub[k])!=sub[k]) {
						flag=false;
						break;
					}
				}
				if(flag) cnt++;
				
			}
			ret.add(cnt);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int num:ret)
		sb.append(num+"\n");
		
		System.out.print(sb.toString());
		br.close();
	}
	
}




