
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
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Long> q = new PriorityQueue<>((a,b)->{
			return -Long.compare(a, b);
		});
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			
			if(num!=0) {
				q.add(num);
			}
			else {
				if(!q.isEmpty())
				sb.append(q.poll()+"\n");
				else
					sb.append(0+"\n");
			}
		}
		System.out.print(sb.toString());
		br.close();
	}
	
}




