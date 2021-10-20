
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
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i<N+1; i++)
			list.add(new ArrayList<>());
		boolean[] visit = new boolean[N+1];
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		visit[1]=true;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int[] ret = new int[N+1];
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i=0; i<list.get(node).size(); i++) {
				int num = list.get(node).get(i);
				if(visit[num]) continue;
				visit[num]=true;
				
				q.add(num);
				ret[num]=node;
			}
		}
		
		for(int i=2; i<N+1; i++) {
			System.out.println(ret[i]);
		}
		
		br.close();
	}
	
}





