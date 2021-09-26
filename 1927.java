
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

	
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			if(num==0) {
				if(q.isEmpty()) {
					sb.append(0+"\n");
				}
				else {
					sb.append(q.poll()+"\n");
				}
			}
			else {
				q.add(num);
			}
		}
		
		System.out.println(sb.toString());
	}
	
}



