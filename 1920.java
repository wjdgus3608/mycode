
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		HashSet<Long> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			
			
			set.add(Long.parseLong(st.nextToken()));
		}
		
		M =Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			long num = Long.parseLong(st.nextToken());
			if(set.contains(num)) sb.append(1+"\n");
			else sb.append(0+"\n");
		}
		System.out.println(sb);
	}
	
}



